package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        // jdbcTemplate.queryForObject("select conut(1) from account_tb1");
        // jdbcTemplate.queryForList("select conut(1) from account_tb1");
        Long aLong = jdbcTemplate.queryForObject("select count(1) from account_tb1", Long.class);
        log.info("记录总数: {}", String.valueOf(aLong));
        log.info("数据源类型：{}", dataSource.getClass());
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1L);
        log.info("用户信息：{}", user);
    }


}
