package com.zengcl.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZCL
 * @Date: 2023/12/18 22:37
 * @Description:redisson配置类
*/
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    String port;
    @Value("${spring.redis.password}")
    String password;
    @Value("${spring.redis.database}")
    Integer database;

    @Bean
    public RedissonClient redissonClient(){
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+host+":"+port)
                .setPassword(password)
                .setDatabase(database);
        // 创建RedissonClient对象
        return Redisson.create(config);
    }
}
