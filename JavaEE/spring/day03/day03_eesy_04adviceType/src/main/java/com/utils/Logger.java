package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，提供了公共的代码
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知：Logger类中的beforePrintLog开始记录日志...");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知：Logger类中的afterReturningPrintLog()开始记录日志...");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知：Logger类中的afterThrowingPrintLog()开始记录日志...");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知：Logger类中的afterPrintLog()开始记录日志...");
    }

    /**
     * 环绕通知
     *
     * 问题：当配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     *      spring框架提供了一个接口：ProceedingJoinPoint；该接口有一个方法：proceed()，此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时：spring框架会为我们提供该接口的实现类供我们使用
     *
     * sprig中的环绕通知：
     *      它是spring框架为我们提供的一种 可以在代码中手动控制增强方法何时执行 的方式
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("前置通知：Logger类中的aroundPrintLog()开始记录日志");
            rtValue = pjp.proceed();//明确调用业务层方法(切入点方法)
            System.out.println("后置通知：Logger类中的aroundPrintLog()开始记录日志");
            return rtValue;
        }catch (Throwable t){
            System.out.println("异常通知：Logger类中的aroundPrintLog()开始记录日志");
            throw new RuntimeException(t);
        }finally {
            System.out.println("最终通知：Logger类中的aroundPrintLog()开始记录日志");
        }
    }
}
