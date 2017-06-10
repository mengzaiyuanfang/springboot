package com.zhousui.exceptionhandler;

import javax.management.RuntimeOperationsException;

/**
 * Created by lenovo on 2017/5/28.
 */
public class GirlException extends RuntimeException{
    private String retCode;
    private String retDesc;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }
    public GirlException(String retCode,String retDesc)
    {
        //super(retDesc);
        this.retCode = retCode;
        this.retDesc = retDesc;
    }

    public GirlException(ExceptionEnum exceptionEnum)
    {
        this.retDesc = exceptionEnum.getRetDesc();
        this.retCode = exceptionEnum.getRetCode();
    }
}
