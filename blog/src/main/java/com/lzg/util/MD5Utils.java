package com.lzg.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @PACKAGE_NAME: com.lzg.util
 * @NAME: MD5Util
 * @USER: 86185
 * @DATE: 2020/7/31
 * @TIME: 11:26
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 31
 * @DAY_NAME_SHORT: 周五
 * @DAY_NAME_FULL: 星期五
 * @HOUR: 11
 * @MINUTE: 26
 * @PROJECT_NAME: blog
 **/
public class MD5Utils {

    /**
     * MD5加密类
     * @param str 要加密的字符串
     * @return    加密后的字符串
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成加密字符串
     * @param args
     */
    public static void main(String[] args){
        System.out.println(code("20200508"));
    }
}
