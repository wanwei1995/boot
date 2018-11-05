package com.ww.springboot.boot.shiro.cache;
//package com.topideal.supplychain.tms.system.cache;
//
//import java.io.Serializable;
//import java.util.concurrent.TimeUnit;
//import org.apache.log4j.Logger;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisTemplate;
//
///**
// * @author hhl
// * @date 2018/6/4
// */
//public class RedisSessionDAO  extends EnterpriseCacheSessionDAO {
//
//    private static final Logger logger = Logger.getLogger(RedisSessionDAO.class);
//
//    // session 在redis过期时间是30分钟30*60
//    private static final int EXPIRE_TIME = 1800;
//    private static String prefix = "shiro-session:";
//
//    @Autowired
//    @Qualifier("redisTemplateObj")
//    private RedisTemplate<Object, Object> redisTemplate;
//
//    // 创建session，保存到数据库
//    @Override
//    protected Serializable doCreate(Session session) {
//        Serializable sessionId = super.doCreate(session);
//        this.logger.info("创建session:{}"+session.getId());
//        redisTemplate.opsForValue().set(prefix + sessionId.toString(), session);
//        return sessionId;
//    }
//
//    // 获取session
//    @Override
//    protected Session doReadSession(Serializable sessionId) {
//        this.logger.info("获取session:{}"+sessionId);
//        this.logger.info("test:{}"+sessionId);
//        // 先从缓存中获取session，如果没有再去数据库中获取
//        Session session = super.doReadSession(sessionId);
//        if (session == null) {
//            session = (Session) redisTemplate.opsForValue().get(prefix + sessionId.toString());
//        }
//        return session;
//    }
//
//    // 更新session的最后一次访问时间
//    @Override
//    protected void doUpdate(Session session) {
//        super.doUpdate(session);
//        this.logger.info("获取session:{}"+session.getId());
//        String key = prefix + session.getId().toString();
//        if (!redisTemplate.hasKey(key)) {
//            redisTemplate.opsForValue().set(key, session);
//        }
//        redisTemplate.expire(key, EXPIRE_TIME, TimeUnit.SECONDS);
//    }
//
//    // 删除session
//    @Override
//    protected void doDelete(Session session) {
//        this.logger.info("删除session:{}"+session.getId());
//        super.doDelete(session);
//        redisTemplate.delete(prefix + session.getId().toString());
//    }
//}
