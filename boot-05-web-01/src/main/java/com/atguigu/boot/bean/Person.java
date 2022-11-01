package com.atguigu.boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author chenpi
 * @create 2022-11-01 23:04
 */
@Data
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
