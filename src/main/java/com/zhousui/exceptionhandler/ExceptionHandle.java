package com.zhousui.exceptionhandler;

import com.zhousui.Utils.ResultUtil;
import com.zhousui.domain.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Created by lenovo on 2017/5/28.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody




    //@Responsebody与@RequestBody - guodefu909 - 博客园  http://www.cnblogs.com/guodefu909/p/4216327.html
    //把异常信息放在一个公共类里面统一处理aaa
    public  Result handler(Exception exception)
    {
        if(exception instanceof GirlException)
        {
            GirlException exceptionGirl = (GirlException)exception;
            Result result = ResultUtil.fail(exceptionGirl.getRetCode(),exceptionGirl.getRetDesc());
            return result;
        }
        else
        {
            logger.error("【系统异常】={}",exception);
            //Result result = ResultUtil.fail("-1","未知错误");
            Result result = ResultUtil.fail(ExceptionEnum.UNKNOW_ERROR.getRetCode(),ExceptionEnum.UNKNOW_ERROR.getRetDesc());
            return result;
        }
      /*  Result result = new Result();
        result = ResultUtil.fail("100",exception.getMessage());
        return result;*/
    }

}
