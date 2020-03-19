package service.impl;

import service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(){
        System.out.println("对象创建了...");
    }

    public void saveAccount() {
        System.out.println("service的saveAccount()执行...");
    }

}
