package com.zsl.homestay.configuration;

public class MyException extends RuntimeException {
    private Integer code;
    private String message;

    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
