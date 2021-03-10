package com.lzydmc.bookstore.util;

import com.lzydmc.bookstore.common.Constant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //返回加盐数据
        return Base64.encodeBase64String(md5.digest((Constant.SALT+strValue).getBytes()));
    }

//    public static void main(String[] args) {
//        String md5 = null;
//        try{
//            md5 = getMD5Str("1234");
//        }catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//        }
//        System.out.println(md5);
//    }
}
