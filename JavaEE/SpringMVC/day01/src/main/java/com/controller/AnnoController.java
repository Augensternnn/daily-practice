package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})//把 msg=嘻嘻 存入到session域对象中
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("testRequestParam()执行了...");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求头内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) throws UnsupportedEncodingException {
        System.out.println("testRequestBody()执行了...");
        System.out.println(URLDecoder.decode(body,"utf-8"));
        return "success";
    }

    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
//    @RequestMapping(value = "/testPathVariable/{sid}",method = RequestMethod.PUT)
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("testPathVariable()执行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * RequestHeader注解
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("testRequestHeader()执行了...");
        System.out.println(header);
        return "success";
    }

    /**
     * CookieValue注解
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("testCookieValue()执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     *      放方法上：优先执行该方法
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute()执行了...");
        System.out.println(user);
        return "success";
    }
    /**
     * 该方法会先执行
     */
    /*//有返回值
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser()执行了...");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/
    //没有返回值
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser()执行了...");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }

    /**
     * SessionAttributes注解：只能作用在类上
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes()执行了...");
        //底层会存储到request域对象中
        model.addAttribute("msg","嘻嘻");
        return "success";
    }
    /**
     * 从session中获取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes()执行了...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 从session中删除值
     * @param status
     * @return
     */
    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status){
        System.out.println("getSessionAttributes()执行了...");
        status.setComplete();
        return "success";
    }
}
