package com.atguigu.boot.bean;

import lombok.*;

/**
 * 用户
 *
 * @author chenpi
 * @create 2022-10-18 19:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
