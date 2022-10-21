package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 *
 * @author chenpi
 * @create 2022-10-18 21:45
 */
@Data
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;//品牌
    private Integer price;//价格

}
