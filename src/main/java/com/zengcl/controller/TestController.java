package com.zengcl.controller;

import com.zengcl.config.RedissonConfig;
import com.zengcl.util.JedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Api(tags = "首页模块")
@RestController
public class TestController {

    private RedissonConfig redissonConfig;
    private final JedisUtil jedisUtil;

    public TestController(RedissonConfig redissonConfig, JedisUtil jedisUtil) {
        this.redissonConfig = redissonConfig;
        this.jedisUtil = jedisUtil;
    }
    @ApiOperation(value = "向客人问好")
    @GetMapping("/a")
    public void a(){
        RLock lock = redissonConfig.redissonClient().getLock("a");
        try{
            if(!lock.tryLock(3000, TimeUnit.MILLISECONDS)){
                System.out.println("占用");
                return;
            }
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
