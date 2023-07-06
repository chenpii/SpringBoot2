package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.mapper.AccountMapper;
import com.atguigu.admin.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    AccountMapper accountMapper;

    public Account getAccountById(Long id) {
        return accountMapper.getAccount(id);
    }
}
