package com.ww.springboot.boot.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5数字签名工具类
 * 
 * @author zhoulei0046
 *
 */
public class MD5Util {

    private static MessageDigest instance;

    private static Object LOCK = new Object();

    public static MessageDigest getDigest() {
        try {
            if (instance == null) {
                synchronized (LOCK) {
                    if (instance == null) {
                        instance = MessageDigest.getInstance("MD5");
                    }
                }
            }
            return instance;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] md5(byte[] data) {
        return getDigest().digest(data);
    }

    public static byte[] md5(String data) {
        return md5(data.getBytes());
    }

    public static String md5Hex(byte[] data) {
        return HexUtil.toHexString(md5(data));
    }

    public static String md5Hex(String data) {
        return HexUtil.toHexString(md5(data));
    }

    /**
     * 数字签名认证
     * 
     * @param parameteres
     * @param sign
     * @param privateKey
     * @return
     */
    public static boolean validateSign(String sign, String privateKey, String... parameteres) {
        boolean result = false;
        if (parameteres == null || parameteres.length == 0 || sign == null) {
            return false;
        }
        StringBuffer sb = new StringBuffer();
        for (String s : parameteres) {
            sb.append(s);
        }
        sb.append(privateKey);
        String signed = md5Hex(sb.toString());
        result = sign.equalsIgnoreCase(signed);
        return result;
    }
}
