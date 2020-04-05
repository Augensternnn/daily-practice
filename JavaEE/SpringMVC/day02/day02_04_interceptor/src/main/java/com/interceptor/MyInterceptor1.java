package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 预处理，controller方法执行前
     * @param request
     * @param response
     * @param handler
     * @return  true：放行，执行下一个拦截器(若没有拦截器了，就执行controller中的方法)
     *          false：不放行，使用request、response跳转到某页面
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行...前");
        /*request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return false;*/
        return true;
    }

    /**
     * 后处理方法：controller方法执行完，往别的页面跳转时，回来经过该拦截器时执行的方法 [controller方法执行之后，success.jsp执行之前]
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行...后");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }

    /**
     * success.jsp页面执行后，该方法会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1执行...最后");
    }
}
