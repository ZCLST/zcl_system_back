package com.zengcl.controller;

import com.zengcl.config.RedissonConfig;
import com.zengcl.util.JedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
public class TestController {

    private RedissonConfig redissonConfig;
    private final JedisUtil jedisUtil;

    public TestController(RedissonConfig redissonConfig, JedisUtil jedisUtil) {
        this.redissonConfig = redissonConfig;
        this.jedisUtil = jedisUtil;
    }

    @GetMapping("/a")
    public void a(){
        Jedis jedis = jedisUtil.getJedis();
        jedis.set("1","1");
        String s = jedis.get("1");
        System.out.println(s);
    }
}
