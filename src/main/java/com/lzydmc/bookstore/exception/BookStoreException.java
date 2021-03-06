package com.lzydmc.bookstore.exception;

/**
 * 描述：     统一异常
 */
public class BookStoreException extends RuntimeException {

    private final Integer code;
    private final String message;

    public BookStoreException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BookStoreException(BookStoreExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
