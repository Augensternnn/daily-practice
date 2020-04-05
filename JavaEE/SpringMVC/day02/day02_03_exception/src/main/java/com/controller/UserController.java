package com.controller;

import com.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException()执行...");

        try {
            //模拟异常
            int a = 10/0;
        } catch (Exception e) {
            //控制台打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有用户出现错误...");
        }

        return "success";
    }
}
