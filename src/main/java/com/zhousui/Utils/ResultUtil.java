package com.zhousui.Utils;

import com.zhousui.domain.Result;
import com.zhousui.exceptionhandler.ExceptionEnum;
import com.zhousui.model.GirlNew;

/**
 * Created by lenovo on 2017/5/28.
 */
public class ResultUtil {
    public static Result success(Object object)
    {
        Result result = new Result();
       /* result.setRetCode("0");
        result.setRetDesc("success");*/
        result.setRetCode(ExceptionEnum.SUCCESS.getRetCode());
        result.setRetDesc(ExceptionEnum.SUCCESS.getRetDesc());
        result.setData(object);
        return result;

    }
    public static Result fail(String retCode,String retDesc)
    {
        Result result = new Result();
        result.setRetCode(retCode);
        result.setRetDesc(retDesc);
        return result;
    }
}
