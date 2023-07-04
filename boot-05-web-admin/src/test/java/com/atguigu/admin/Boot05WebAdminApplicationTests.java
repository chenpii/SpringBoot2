package com.atguigu.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        // jdbcTemplate.queryForObject("select conut(1) from account_tb1");
        // jdbcTemplate.queryForList("select conut(1) from account_tb1");
        Long aLong = jdbcTemplate.queryForObject("select count(1) from account_tb1", Long.class);
        log.info("记录总数: {}" , String.valueOf(aLong));
    }


}
