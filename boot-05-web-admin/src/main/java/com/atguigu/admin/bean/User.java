package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    /**
     * 要求所有的属性都应该在数据库里面存在
     */
    @TableField(exist = false) //加上此注解后，属性不在数据库里也不报错
    private String userName;
    @TableField(exist = false)
    private String password;

    //数据库里的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
