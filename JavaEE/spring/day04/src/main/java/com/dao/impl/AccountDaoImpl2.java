package com.dao.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【推荐：注解配置】
 * 可以用作于基于xml、注解两种配置方法
 */
@Repository
public class AccountDaoImpl2 implements IAccountDao {
    @Autowired
    private JdbcTemplate template;

    public Account findAccountById(Integer accountId) {
        List<Account> accounts = template.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = template.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if (accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        template.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
