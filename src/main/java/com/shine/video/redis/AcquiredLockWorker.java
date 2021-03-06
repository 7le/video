package com.shine.video.redis;

/**
 * 获取锁后需要处理的逻辑
 *
 * @author 7le
 */
@FunctionalInterface
public interface AcquiredLockWorker<T> {

    T invokeAfterLockAcquire() throws Exception;
}
