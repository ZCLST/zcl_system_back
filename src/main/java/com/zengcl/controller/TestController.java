package com.zengcl.controller;

import com.zengcl.config.RedissonConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private RedissonConfig redissonConfig;

    public TestController(RedissonConfig redissonConfig) {
        this.redissonConfig = redissonConfig;
    }

    @GetMapping("/a")
    public void a(){

    }
}
