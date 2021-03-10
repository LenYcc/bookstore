package com.lzydmc.bookstore.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component//注解
public class Constant {
    public static final String SALT = "?'{dsfjk}'][";
    public static final String BOOKSTORE_USER = "bookstore_user";
    public static final Integer BOOKSTORE_HOT_NUM = 10;



    public static String FILE_UPLOAD_DIR;

    @Value("${file.upload.dir}")
    public void setFileUploadDir(String fileUploadDir) {
        FILE_UPLOAD_DIR = fileUploadDir;
    }
}
