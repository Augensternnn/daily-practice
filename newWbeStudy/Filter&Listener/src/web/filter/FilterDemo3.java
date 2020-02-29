package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象的请求消息增强
        System.out.println("FilterDemo3执行了...");
        //放行
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("FilterDemo3回来了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
