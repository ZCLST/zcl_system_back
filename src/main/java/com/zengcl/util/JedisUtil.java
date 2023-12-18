package com.zengcl.util;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author zcl
 * @create 2021/7/25 18:30
 * @desc jedis工具类
 **/
public class JedisUtil {
    private static JedisPool jedisPool = null;
    @Value("${spring.redis.host}")
    static String host;
    @Value("${spring.redis.port}")
    static Integer port;
    @Value("${spring.redis.password}")
    static String password;
    @Value("${spring.redis.database}")
    static Integer database;
    @Value("${spring.redis.maxToal}")
    static int maxToal;
    @Value("${spring.redis.maxIdel}")
    static int maxIdel;
    @Value("${spring.redis.timeout}")
    static Integer timeOut;

    //初始化
    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdel);
        jedisPoolConfig.setMaxTotal(maxToal);
        jedisPoolConfig.setMaxWaitMillis(timeOut);
        jedisPool = new JedisPool(jedisPoolConfig, host, port, timeOut, password);
    }

    /**
     * 获取JEDIS客户端
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 关闭jedis客户端
     *
     * @param jedis
     */
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
