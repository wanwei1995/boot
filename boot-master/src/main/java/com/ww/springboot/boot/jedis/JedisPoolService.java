package com.ww.springboot.boot.jedis;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ww.springboot.boot.utils.JacksonUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author wanwei
 * @TODO   redis方法 使用了单例模式，以及代码块加锁；
 * @date: 2018年9月27日 上午11:39:34 
 */
@Component
public class JedisPoolService {

    @Autowired
    private JedisConfig jedisConfig;

    private JedisPool jedisPool;
    
    public JedisPool getJedisPool() {

        if (jedisPool == null) {
            // 双重检查加锁，只有在第一次实例化时，才启用同步机制，提高了性能。
            synchronized (JedisPoolService.class) {
                if (jedisPool == null) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    jedisPool =
                            new JedisPool(poolConfig, jedisConfig.getHost(), jedisConfig.getPort(),
                                    jedisConfig.getTimeout(), jedisConfig.getPassword());
                }
            }
        }
        return jedisPool;
    }

    private String getNamespaceKey(String key) {
        return jedisConfig.getNamespace() + key;
    }

    public void set(String key, String value) {
        try (Jedis jedis = getJedisPool().getResource()) {
            //jedis.set(key, value);
            jedis.set(getNamespaceKey(key), value);
        }
    }

    public String get(String key) {
        try (Jedis jedis = getJedisPool().getResource()) {
            return jedis.get(getNamespaceKey(key));
        }
    }

    /**
     * 根据前缀删除缓存
     * 
     * @param key
     * @return
     */
    public boolean delPrefix(String key) {
        try (Jedis jedis = getJedisPool().getResource()) {
            Set<String> set = jedis.keys(getNamespaceKey(key) + "*");
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String keyStr = it.next();
                jedis.del(keyStr);
            }
            return true;
        }
    }
    
    /**
     * 删除所有缓存
     * 
     * @param key
     * @return
     */
    public boolean clear() {
        try (Jedis jedis = getJedisPool().getResource()) {
            Set<String> set = jedis.keys(jedisConfig.getNamespace() + "*");
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String keyStr = it.next();
                jedis.del(keyStr);
            }
            return true;
        }
    }

    public void del(String key) {
        try (Jedis jedis = getJedisPool().getResource()) {
            jedis.del(getNamespaceKey(key));
        }
    }

    public void setObj(String key, Object obj) {
        if (obj == null) {
            return;
        }

        try (Jedis jedis = getJedisPool().getResource()) {
            jedis.set(key, JacksonUtil.toJSon(obj));
            jedis.set(getNamespaceKey(key), JacksonUtil.toJSon(obj));
        }
    }

    public <T> T getObj(String key, Class<T> clazz) {
        try (Jedis jedis = getJedisPool().getResource()) {
            String v = jedis.get(getNamespaceKey(key));
            if (StringUtils.isEmpty(v)) {
                return null;
            }
            return JacksonUtil.readValue(v, clazz);
        }
    }

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final int EXPIRE_TIME = 300000 ;
    private static final String RELEASE_SUCCESS = "1";

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否获取成功
     */
    public boolean tryGetDistributedLock(String lockKey, String requestId) {
        try (Jedis jedis = getJedisPool().getResource()) {
            String result = jedis.set(getNamespaceKey(lockKey), requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, EXPIRE_TIME);

            if (LOCK_SUCCESS.equals(result)) {
                return true;
            }
            return false;
        }

    }

    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public boolean releaseDistributedLock( String lockKey, String requestId) {
        try (Jedis jedis = getJedisPool().getResource()) {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(getNamespaceKey(lockKey)),
                    Collections.singletonList(requestId));

            if (result!= null && RELEASE_SUCCESS.equals(result.toString())) {
                return true;
            }
            return false;
        }

    }

}

