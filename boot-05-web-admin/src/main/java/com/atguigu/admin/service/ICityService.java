package com.atguigu.admin.service;

import com.atguigu.admin.bean.City;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ICityService  {
    public City getCityById(Long id);

    public void saveCity(City city);
}
