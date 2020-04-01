package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类：用于接收请求
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello SpringMVC！");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(value = "/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
