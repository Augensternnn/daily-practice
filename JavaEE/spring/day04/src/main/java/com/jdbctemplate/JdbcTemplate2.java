package com.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的基本用法 --- 2
 */
public class JdbcTemplate2 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate template = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        template.execute("insert into account(name,money) values('d',2000)");
    }
}
