package com.proxy;

import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();

        /**
         * 动态代理
         *   特点：字节码随用随创建，随用随加载
         *   作用：不修改源码的基础上对方法增强
         *   分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *   基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：jdk官方
         *   如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *   创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能使用
         *   newProxyInstance方法的参数：
         *      ClassLoader：类加载器    【固定写法】
         *          用于加载代理对象字节码，写的是被代理对象的类加载器 [和被代理对象使用相同的类加载器]
         *      Class[]
         *      InvocationHandler
         *
         */
        Proxy.newProxyInstance(producer.getClass().getClassLoader());
    }
}
