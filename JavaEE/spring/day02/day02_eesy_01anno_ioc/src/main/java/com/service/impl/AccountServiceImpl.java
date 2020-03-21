package com.service.impl;

import com.dao.IAccountDao;
import com.dao.impl.AccountDaoImpl;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * xml的配置：
 *  <bean id="accountService" class="service.impl.AccountServiceImpl"
 *      scope="" init-method="" destroy-method="">
 *      <property name="" value="" / ref=""></property>
*   </bean>
 *
 * 【注解中：如果只有一个value属性，且只有一个值，则value可以省略】
 * 用于创建对象的
 *      他们的作用和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *      Component
 *          作用：用于把当前类对象存入spring容器中
 *          属性：
 *              value：用于指定bean的id；当我们不写时，默认值是当前类名且首字母改小写
 *
 *      ==============================================================================
 *                         以下三个注解的作用和属性与Component是一模一样的
 *         他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *      ==============================================================================
 *      Controller：一般用于表现层
 *      Service：一般用于业务层
 *      Repository：一般用于持久层
 *
 * 用于注入数据的
 *      他们的作用和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的
 *      Autowired：
 *          作用：自动按照类型注入；只有容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *              如果IOC容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *              如果IOC容器中有多个类型匹配时
 *          出现位置：
 *              可以是变量上，也可以是方法上
 *          细节：
 *              使用注解注入时，set方法就不是必须的了
 *      Qualifier:
 *          作用：在按照类型注入的基础之上，再按照名称注入。
 *               它在给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *               在给类成员注入时，不能单独使用，必须和Autowired配合使用
 *          属性：
 *              value：用于指定注入bean的id
 *      Resource：
 *          作用：直接按照bean的id注入。它可以独立使用
 *          属性：
 *              name：用于指定bean的id
 *      =================================================================================
 *      以下三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *      另外，集合类型的注入只能通过xml来实现
 *      =================================================================================
 *      value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值。他可以使用spring中的SpEL(也就是spring中的el)
 *                      SpEL的写法：${表达式}
 *
 * 用于改变作用范围的
 *      他们的作用和在bean标签中使用scope属性实现的功能是一样的
 *      Scope：
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值 [不写：默认单例]
 *                  常用取值：singleton、prototype
 *
 * 和生命周期相关的：[了解]
 *      他们的作用和在bean标签中使用init-method和destroy-method的作用的一样的
 *      PreDestroy：
 *          作用：用于指定销毁方法
 *      PostConstruct：
 *          作用：用于指定初始化方法
 */
//@Component(value = "accountService")
@Service("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name="accountDao2")
    private IAccountDao accountDao1 = null;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行...");
    }

    public void saveAccount() {
        accountDao1.saveAccount();
    }

}
