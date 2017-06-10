package com.zhousui.exceptionhandler;

/**
 * Created by lenovo on 2017/5/28.
 */
public enum ExceptionEnum {
    UNKNOW_ERROR("-1","未知错误"),
    SUCCESS("0","成功"),
    PRIMARY("100","你还在上初中吧"),
    MIDDLE("101","你还在上小学吧"),
    ;
    private String retCode;
    private String retDesc;

    ExceptionEnum(String retCode, String retDesc) {
        this.retCode = retCode;
        this.retDesc = retDesc;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }
}
