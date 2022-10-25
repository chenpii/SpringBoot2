package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    // /car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("age") Integer age,
                                      @RequestParam List<String> inters,
                                      @RequestParam Map<String, String> params) {
        Map<String, Object> map = new HashMap<>();
        // map.put("id", id);
        // map.put("username", name);
        // map.put("pv", pv);
        // map.put("userAgent", userAgent);
        // map.put("headers", headers);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String context) {
        Map<String, Object> map = new HashMap<>();
        map.put("context", context);
        return map;

    }
}
