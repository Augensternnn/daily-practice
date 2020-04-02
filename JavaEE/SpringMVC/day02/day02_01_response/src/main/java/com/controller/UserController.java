package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/returnString")
    public String returnString(Model model){
        System.out.println("returnString()执行...");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("哈哈");
        user.setPassword("123");
        user.setAge(18);
        //存储对象：Model对象
        model.addAttribute("user",user);
        return "success";
    }
}
