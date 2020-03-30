package com.jdbctemplate;

import com.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplate3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate template = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//        template.update("insert into account(name,money) values(?,?)","eee",3000);
        //更新
//        template.update("update account set name=?,money=? where id=?","lll",900,5);
        //删除
//        template.update("delete from account where id=?",6);
        //查询所有
//        List<Account> accounts = template.query("select * from account where money > ?", new AccountRowMapper(), 1000f);
//        List<Account> accounts = template.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> accounts = template.query("select * from account where money = ?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        //查询返回一行一列(使用聚合函数，但不加group by子句)
        Long count = template.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 将结果集中的数据封装到Account中，然后由spring把每一个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}