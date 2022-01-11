package com.example.springbootchatroom.code.exception;

/**
 * 自定义注册异常
 */
public class RegisterException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RegisterException() {

    }

    public RegisterException(String msg) {
        super(msg);
    }

}
