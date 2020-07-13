package com.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Intercepts：完成插件签名
 * 目的：告诉Mybatis当前插件用来拦截哪个对象的哪个方法
 *
 * @Signature：
 *      type：指拦截四大对象中哪个对象
 *      method：拦截对象的哪个方法
 *      args：当前方法的参数列表
 */
@Intercepts({
        @Signature(type = StatementHandler.class,method = "parameterize",args = java.sql.Statement.class )
    })
public class MyFirstPlugin implements Interceptor {
    /**
     * intercept：拦截
     * 拦截目标对象的目标方法的执行
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin的intercept()："+invocation.getMethod());

        //动态改变一下Sql运行的参数，例：查询1号员工，实际从数据库查询3号员工
        Object target = invocation.getTarget();
        System.out.println("当前拦截到的对象："+target);
        //拿到 StatementHandler->ParameterHandler->parameterObject
        MetaObject metaObject = SystemMetaObject.forObject(target);//拿到目标对象(target)的原数据
        Object value = metaObject.getValue("parameterHandler.parameterObject");//getValue()：获取哪个属性的值
        System.out.println("sql语句用的参数是："+value);
        //修改sql语句要用的参数
        metaObject.setValue("parameterHandler.parameterObject",11);

        //执行目标方法 [没有该步，目标方法不执行]
        Object proceed = invocation.proceed();
        //返回执行后的返回值
        return proceed;
    }

    /**
     * 包装目标对象
     *      包装：为目标对象创建一个代理对象
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("MyFirstPlugin的plugin()，mybatis将要包装的对象："+target);
        //借助Plugin的wrap()方法使用当前拦截器(intercept)包装目标对象
        Object wrap = Plugin.wrap(target, this);
        //返回为当前target创建的动态代理
        return wrap;
    }

    /**
     * 将插件注册时的property属性设置进来
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("MyFirstPlugin的setProperties()...");
        System.out.println("插件配置的信息："+properties);
    }
}
