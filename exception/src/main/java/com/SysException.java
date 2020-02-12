package com;

/**
 * @outhor li
 * @create 2020-02-12 9:44
 */
public class SysException extends Exception{
    //存储提示信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
