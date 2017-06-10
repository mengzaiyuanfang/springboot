package com.zhousui.controller;

import com.zhousui.domain.Girl;
import com.zhousui.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lenovo on 2017/5/21.
 */
@RestController
@RequestMapping("/girl/many")
public class HelloController {
    //  @Value("${cupSize}")
    //private String cupSize;
    //@Value("${age}")
    //private Integer age;
    ////&#x8bfb;&#x53d6;&#x914d;&#x7f6e;&#x6587;&#x4ef6;&#x4e2d;&#x7684;&#x503c;
    //@Value("${content}")
    //private String content;
    @Autowired
  private GirlProperties girlProperties;

    @RequestMapping(value ={"/hello","/hi"},method= RequestMethod.GET)
    public String sayHello()
    {
        return girlProperties.getAge()+girlProperties.getCupSize()+"sayhello";
    }
    @RequestMapping(value ={"/hello","/hi"},method= RequestMethod.POST)
    public String sayHello1()
    {
        return girlProperties.getAge()+girlProperties.getCupSize();
    }
    @RequestMapping(value ="/hello/{id}",method= RequestMethod.GET)
    public String sayHello2(@PathVariable("id") int id)
    {
        return "id:"+id+"====/hello/{id}";
    }
    @RequestMapping(value ="/{id}/hello",method= RequestMethod.GET)
    //试下，没有pathVariable这个注解，会报错，拿不到URL中的ID
    public String sayHello3(@PathVariable("id") int id)
    {
        return "id:"+id+"/{id}/hello";
    }
    @RequestMapping(value ="/hello/query",method= RequestMethod.GET)
    //或者用GetMapping(value ="/hello/query")
    //注解中的id要与URL中的id名字一样，但是不需要与int id这里的名字一样
    //这里的id用int与用Integer还是有很大区别的，一个URL中传空不报错，一个报错
    public String sayHello4(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id)
    {
        return "id:"+id+"/hello";
    }
    @RequestMapping(value="/hello/girl",method = RequestMethod.POST,consumes = "application/json")
    //对于body，少不了@RequestBody，没有对象的值则为空
    //同样少不了consumes = "application/json"这个注解。
    public String sayHello5(@RequestBody Girl girl)
    {
        return girl.getAge()+girl.getId()+girl.getName();
    }
}
