package com.ww.springboot.boot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ww.springboot.boot.exception.BusinessException;

/**
 * @description: HS256加解密
 * @author: wanwei
 * @create: 2019-03-18 16:59
 **/
public class MyJwtParseUtil {


    /**
     * 生成token HS256
     *
     * @param key
     * @return
     */
   public static String createToken(String key){
       try {
           Algorithm algorithm = Algorithm.HMAC256(key);
           return JWT.create()
                   .withIssuer("auth0")
                   .sign(algorithm);
       } catch (JWTCreationException exception){
           throw new BusinessException("生成token失败");
       }
   }

    /**
     * 解析token HS256
     *
     * @param token
     * @param key
     * @return
     */
    public static boolean parseToken(String token, String key) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            verifier.verify(token);
        }catch (JWTVerificationException exception){
            return false;
        }
        return true;
    }
}
