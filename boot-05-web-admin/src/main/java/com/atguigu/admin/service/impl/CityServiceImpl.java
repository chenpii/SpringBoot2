package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl  implements ICityService {
    @Autowired
    CityMapper cityMapper;

    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }

}
