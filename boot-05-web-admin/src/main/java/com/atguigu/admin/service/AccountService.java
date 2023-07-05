package com.atguigu.admin.service;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Account getAccountById(Long id) {
        return accountMapper.getAccount(id);
    }
}
