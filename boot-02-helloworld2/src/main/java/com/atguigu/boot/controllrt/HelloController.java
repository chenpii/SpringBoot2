package com.atguigu.boot.controllrt;

import com.atguigu.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpi
 * @create 2022-10-23 17:25
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Person person;


    @RequestMapping("/person")
    public Person person() {
        log.info(person.getUsername());
        return person;
    }
}
