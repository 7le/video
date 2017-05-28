package com.shine.video.util;

import java.util.Calendar;

/**
 * 时间类
 */
public class TimeUtil {

    public static long getTimeStamp() {
        Long time = System.currentTimeMillis();
        String str=time.toString().substring(0, time.toString().length() - 3);
        return Long.parseLong(str);
    }

    /**
     * 获得当前日期
     *
     * @return 格式 YYYYMMDD
     */
    public static String getNowOfdate() {
        Calendar calender = Calendar.getInstance(); // 获得日历对象

        // 获取即时时间
        String nowDate = String.valueOf(calender.get(Calendar.YEAR))
                + String.format("%02d", calender.get(Calendar.MONTH) + 1)
                + String.format("%02d", calender.get(Calendar.DAY_OF_MONTH));
        return nowDate;

    }

    /**
     * 获得当前到第二天的剩余的时间
     */
    public static Long getTime(){
        long hour = 60 * 60 * 1000;
        long time = System.currentTimeMillis();
        time += 8 * hour;
        time %= 24 * hour;
        time = 24 * hour - time;
        System.out.println("time:"+time);
        return time;
    }

}
