package com.service;

import com.domain.Account;

import java.util.List;

/**
 * @outhor li
 * @create 2020-02-12 22:18
 */
public interface AccountService {
    // 查询所有账户
    public List<Account> findAll();

    // 保存帐户信息
    public void saveAccount(Account account);
}
