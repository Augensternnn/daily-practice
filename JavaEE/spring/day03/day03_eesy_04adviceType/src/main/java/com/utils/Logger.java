package com.utils;

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
}
