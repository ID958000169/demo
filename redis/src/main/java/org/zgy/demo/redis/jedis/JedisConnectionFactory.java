package org.zgy.demo.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.Objects;

/*
 * Jedis连接池
 * */
public class JedisConnectionFactory
{
    private static JedisPool jedisPool;

    static
    {
        // 连接池配置类
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxTotal(20);
        // 最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        // 最小空闲连接数
        jedisPoolConfig.setMinIdle(5);
        // 最大等待时间
        jedisPoolConfig.setMaxWait(Duration.ofMinutes(1));

        jedisPool = new JedisPool(jedisPoolConfig, "192.168.1.172", 6379, 1000, "123@qaz");
    }

    // 获取Jedis
    public static Jedis getJedis()
    {
        return jedisPool.getResource();
    }

    // 关闭连接，如果有连接池的情况下实际上是把连接归还给连接池
    public static void close(Jedis jedis)
    {
        if (Objects.nonNull(jedis))
        {
            jedis.close();
        }
    }
}
