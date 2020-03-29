package com.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的作用：
 *      用于和数据库交互，实现对表的CRUD操作
 *
 * JdbcTemplate的基本用法 --- 1
 */
public class JdbcTemplate1 {
    public static void main(String[] args) {
        //准备数据源：的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("root");

        //1.创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate();
        //2.给template设置数据源
        template.setDataSource(ds);
        //3.执行操作
        template.execute("insert into account(name,money) values('ccc',1000)");
    }
}
