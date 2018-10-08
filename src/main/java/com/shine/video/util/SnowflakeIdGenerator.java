package com.shine.video.util;

/**
 * 分布式ID
 *
 * @author 7le
 */
public class SnowflakeIdGenerator {

    /**
     * 系统开始时间截 (UTC 2017-06-28 00:00:00)
     */
    private static final long startTime = 1498608000000L;

    /**
     * 机器id所占的位数
     */
    private static final long workerIdBits = 10L;

    /**
     * 支持的最大机器id(十进制)，结果是1023 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     * -1L 左移 10位 (worker id 所占位数) 即 10位二进制所能获得的最大十进制数 - 1023
     */
    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * 序列在id中占的位数
     */
    private static final long sequenceBits = 12L;

    /**
     * 机器ID 左移位数 - 12 (即末 sequence 所占用的位数)
     */
    private static final long workerIdMoveBits = sequenceBits;

    /**
     * 时间截向 左移位数 - 22(10+12)
     */
    private static final long timestampMoveBits = sequenceBits + workerIdBits;

    /**
     * 生成序列的掩码(12位所对应的最大整数值)，这里为4095 (0b111111111111=0xfff=4095)
     */
    private static final long sequenceMask = -1L ^ (-1L << sequenceBits);
    //=================================================Works's Parameter================================================
    /**
     * 工作机器ID(0~1023)
     */
    private long workerId;

    /**
     * 毫秒内序列(0~4095)
     */
    private static long sequence = 0L;
    /**
     * 上次生成ID的时间截
     */
    private static long lastTimestamp = -1L;

    private static SnowflakeIdGenerator idWorker;
    //===============================================Constructors=======================================================

    /**
     * 构造函数
     *
     * @param workerId     工作ID (0~1023)
     */
    public SnowflakeIdGenerator(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("Worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
    }

    // ==================================================Methods========================================================

    /**
     * 线程安全的获得下一个 ID 的方法
     */
    public synchronized long nextId() {
        long timestamp = currentTime();
        //如果当前时间小于上一次ID生成的时间戳: 说明系统时钟回退过 - 这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出 即 序列 > 4095
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = blockTillNextMillis(lastTimestamp);
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }
        //上次生成ID的时间截
        lastTimestamp = timestamp;
        return reverse(((timestamp - startTime) << timestampMoveBits) | (workerId << workerIdMoveBits)
                | sequence);
    }

    /**
     * 对long类型的id 进行位反转 （只取正数）
     */
    private static long reverse(long input) {
        long result = 0;
        for (int i = 0; i < 63; i++) {
            if (((input >>> i) & 1L) == 1) {
                int j = 62 - i;
                result |= 1L << j;
            }
        }
        return result;
    }

    /**
     * 阻塞到下一个毫秒 即 直到获得新的时间戳
     */
    private long blockTillNextMillis(long lastTimestamp) {
        long timestamp = currentTime();
        while (timestamp <= lastTimestamp) {
            timestamp = currentTime();
        }
        return timestamp;
    }

    /**
     * 获得以毫秒为单位的当前时间
     */
    private long currentTime() {
        return System.currentTimeMillis();
    }

    synchronized public static void init(long workerId) {
        if (idWorker == null) {
            idWorker = new SnowflakeIdGenerator(workerId);
        }
    }

    public static SnowflakeIdGenerator getInstance() {
        return idWorker;
    }
}
