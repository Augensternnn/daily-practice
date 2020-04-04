package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回值为字符串
     * 底层用的也是ModelAndView
     * @param model
     * @return
     */
    @RequestMapping("/returnString")
    public String returnString(Model model){
        System.out.println("returnString()执行...");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("熊大");
        user.setPassword("456");
        user.setAge(18);
        //存储对象：Model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 返回值为void类型：默认请求 /WEB-INF/pages/user/returnVoid.jsp
     *
     * 请求转发：一次请求；路径不用编写项目的名称
     * 重定向：两次请求；路径要写项目名
     */
    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("returnVoid()执行...");
        /*
        //编写请求转发的程序
        //【手动调用转发的方法，不会再去执行视图解析器】，故不会自动跳转到 /WEB-INF/pages/下是 .jsp 文件，故不可以简写为 "success"
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
         */

        /*
        //重定向
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        */

        //解决中文乱码
        response.setCharacterEncoding("utf-8");//这个也可以不写
        response.setContentType("text/html;charset=utf-8");//设置浏览器解析的编码
        //直接响应
        response.getWriter().write("你好呀");
        response.getWriter().print("你好呀");
        /*
        response.getWriter()返回的是PrintWriter，这是一个打印输出流。
        response.getWriter().print(),不仅可以打印输出文本格式的（包括html标签），还可以将一个对象以默认的编码方式转换为二进制字节输出
        response.getWriter().writer（）,只能打印输出文本格式的（包括html标签），不可以打印对象。
         */

        return;//转发成功后，后面的代码不再执行
    }

    /**
     * 返回值是ModelAndView对象
     */
    @RequestMapping("/returnModelAndView")
    public ModelAndView returnModelAndView(){
        System.out.println("returnModelAndView()执行...");

        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("哈哈");
        user.setPassword("123");
        user.setAge(18);

        //把user对象存储到mv对象中，底层也会把user对象存入request域对象中(ModelAndView底层用的ModelMap)
        mv.addObject("user",user);

        //跳转到哪个页面
        mv.setViewName("success");//设置一个视图的名称
        return mv;
    }

    /**
     * 使用关键字进行转发和重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect()执行...");

        //转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向(这里不用添加项目名，底层已经自动添加了)
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应过程
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax()执行...");
        //客户端发送ajax的请求，传的是json字符串，后端已经将json字符串封装到user对象中了
        System.out.println(user);

        //响应
        //模拟查询数据库
        user.setUsername("haha");
        user.setAge(20);
        return user;
    }
}
