package com.service.impl;

import com.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountService implements IAccountService {
    public void saveAccount() {
        System.out.println("保存...");
//        int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("更新："+i);
    }

    public int deleteAccount() {
        System.out.println("删除...");
        return 0;
    }
}
