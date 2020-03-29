package com.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 用于抽取dao中的重复代码
 */
/*
public class JdbcDaoSupport {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setDataSource(DataSource dataSource) {
        if(template == null){
            template = createJdbcTemplate(dataSource);
        }
    }
    private JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}*/
