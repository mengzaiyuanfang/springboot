package com.zhousui.service;

import com.zhousui.exceptionhandler.ExceptionEnum;
import com.zhousui.exceptionhandler.GirlException;
import com.zhousui.model.GirlNew;
import com.zhousui.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lenovo on 2017/5/28.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo()
    {
        GirlNew girl1 = new GirlNew();
        girl1.setAge(12);
        girl1.setCupSize("B");
        girlRepository.save(girl1);
        int n = 1/0;
        GirlNew girl2 = new GirlNew();
        girl2.setAge(13);
        girl2.setCupSize("Bb");
        girlRepository.save(girl2);
    }

    public void getAge(Integer id) throws  Exception
    {
        GirlNew girl =girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10)
        {
           // throw new GirlException("100","你可能还在上小学吧");
            throw new GirlException(ExceptionEnum.PRIMARY);

        }
        else if(age>10&&age<16)
        {
            //throw new GirlException("101","你可能在上初中吧");
            throw new GirlException(ExceptionEnum.MIDDLE);
        }
    }
}
