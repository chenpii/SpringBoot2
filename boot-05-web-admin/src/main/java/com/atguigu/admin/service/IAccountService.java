package com.atguigu.admin.service;

import com.atguigu.admin.bean.Account;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IAccountService {
    public Account getAccountById(Long id);
}
