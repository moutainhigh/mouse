package com.mouse.core.utils;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ; lidongdong
 * @Description
 * @Date 2020-02-14
 */
@Component
public class RedisLock {

    @Autowired
    private RedissonClient redissonClient;

    public RLock lock(String key) {
        RLock lock = redissonClient.getLock("anyLock" + key);
        lock.lock();
        return lock;
    }
}
