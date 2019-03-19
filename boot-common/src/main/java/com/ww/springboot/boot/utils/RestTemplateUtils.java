package com.ww.springboot.boot.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @description: ${description}
 * @author: wanwei
 * @create: 2019-03-19 09:29
 **/
public class RestTemplateUtils {

    private static Logger logger = LogManager.getLogger(RestTemplateUtils.class);

    public static String post(String reqParam, String url, String tokenKey) {
        // 核心返回结果报文字符串
        String returnJson = "";
        try {
            //复杂构造函数的使用
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setConnectTimeout(18000);// 设置超时
            requestFactory.setReadTimeout(18000);

            //利用复杂构造器可以实现超时设置，内部实际实现为 HttpClient
            RestTemplate restTemplate = new RestTemplate(requestFactory);

            //设置HTTP请求头信息，实现编码等
            HttpHeaders headers = new HttpHeaders();
            headers.set("token", MyJwtParseUtil.createToken(tokenKey));
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());

            //利用容器实现数据封装，发送
            HttpEntity<String> entity = new HttpEntity<String>(reqParam, headers);
            returnJson = restTemplate.postForObject(url, entity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("----------------------------------------");
            logger.info(returnJson);
            logger.info("----------------------------------------");
        }
        return returnJson;
    }


    public static String post(String url, String tokenKey) {

        return post(null, url, tokenKey);
    }


}
