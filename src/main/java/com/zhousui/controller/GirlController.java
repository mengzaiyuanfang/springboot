package com.zhousui.controller;

import com.zhousui.Utils.ResultUtil;
import com.zhousui.domain.Result;
import com.zhousui.model.GirlNew;
import com.zhousui.repository.GirlRepository;
import com.zhousui.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/28.
 */
@RestController
@RequestMapping("/demo")
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    @RequestMapping(value="/girls",method= RequestMethod.GET)
    public List<GirlNew> girlList()
    {
        List<GirlNew> girls = new ArrayList<>();
        girls = girlRepository.findAll();
        return girls;
    }
   /* @RequestMapping(value="/girl",method=RequestMethod.POST)
    public Object saveGirl(@Valid @RequestBody  GirlNew girl, BindingResult bindResult)
    {
        if(bindResult.hasErrors())
        {
            //System.out.println(bindResult.getFieldError().getDefaultMessage());
            return bindResult.getFieldError().getDefaultMessage();
           // return null;
        }
       return  girlRepository.save(girl);
    }*/


    @RequestMapping(value="/girl",method=RequestMethod.POST)
    public Result<GirlNew> saveGirl(@Valid @RequestBody  GirlNew girl, BindingResult bindResult)
    {
        Result result = new Result();
        if(bindResult.hasErrors())
        {
           /* result.setRetCode("-1");
            result.setRetDesc(bindResult.getFieldError().getDefaultMessage());*/
           result = ResultUtil.fail("-1",bindResult.getFieldError().getDefaultMessage());
            return result;
        }
        GirlNew girlresult = girlRepository.save(girl);
       /* result.setRetCode("0");
        result.setRetDesc("success");
        result.setData(girlresult);*/
       //代码优化，将成功失败抽离到公共类中，Result<T>统一了所有返回体，公共工具类由此统一了所有的成功失败处理，方法中用的object用来接收所有的不同
        //对象
       result = ResultUtil.success(girlresult);
        return result;

    }

    @RequestMapping(value ="/girl/query",method=RequestMethod.GET)
    public GirlNew queryGirl(@RequestParam("id") Integer id)
    {
        return girlRepository.findOne(id);
    }

    @RequestMapping(value ="/girl/query/cpu",method=RequestMethod.GET)
    public List<GirlNew> findBycupSize(@RequestParam("cpu") String cupSize)
    {
        return girlRepository.findByCupSize(cupSize);
    }


    @RequestMapping(value="/girl/{id}",method=RequestMethod.DELETE)
    public void deleteGirl(@PathVariable("id") Integer id)
    {
        girlRepository.delete(id);
    }
    @RequestMapping(value = "value/girl",method =RequestMethod.PUT)
    public void updateGirl(@RequestBody GirlNew girl)
    {
        girlRepository.save(girl);
    }
    @RequestMapping(value="/girl/two")
    public void insertTwo()
    {
        girlService.insertTwo();
    }

    @RequestMapping(value="/girl/getAge/{id}",method=RequestMethod.GET)
    public void getAge(@PathVariable("id") Integer id) throws Exception

    {
        girlService.getAge(id);

    }
}
