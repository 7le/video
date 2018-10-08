package com.shine.video.redis;

/**
 * 不能获取锁的异常类
 *
 * @author 7le
 */
public class UnableToAcquireLockException extends RuntimeException {

    public UnableToAcquireLockException() {
    }

    public UnableToAcquireLockException(String message) {
        super(message);
    }

    public UnableToAcquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}