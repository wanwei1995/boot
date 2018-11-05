package com.ww.springboot.boot.shiro.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;

import com.ww.springboot.boot.system.model.User;

public class RedisCache<K, V> implements Cache<K, V> {
    private RedisTemplate<K, V> redisTemplate;
    private final static String PREFIX = "shiro-cache:";
    private String cacheKey;
    private long globExpire = 30;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public RedisCache(final String name, final RedisTemplate redisTemplate) {
        this.cacheKey = PREFIX + name + ":";
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());

    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private K getCacheKey(Object key) {
        if (key instanceof PrincipalCollection) { // 如果key是登录凭证,那么这是访问用户的授权缓存;将登录凭证转为user对象,返回user的id属性做为hash
            // key,否则会以user对象做为hash
            // key,这样就不好清除指定用户的缓存了
            PrincipalCollection pc = (PrincipalCollection) key;
            User user = (User) pc.getPrimaryPrincipal();
            return (K) (cacheKey + user.getId());
        }
        return (K) (cacheKey + key);
    }
}
