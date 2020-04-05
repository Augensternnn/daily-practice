package com.service;

import com.domain.Account;

import java.util.List;

/**
 * 账户service接口
 */
public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    void saveAccount(Account account);
}
