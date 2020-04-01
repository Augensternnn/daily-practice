package com.controller;

import com.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了testParam()...");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success";
    }

    /**
     * 把数据封装到JavaBean的类中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了saveAccount()...");
        System.out.println(account);
        return "success";
    }
}
