package org.zgy.demo.redis.jedis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.zgy.demo.redis.jedis.JedisConnectionFactory;
import org.zgy.demo.redis.jedis.entity.User;
import redis.clients.jedis.Jedis;

@Service
public class JedisServiceImpl implements JedisService
{

    @Override
    public String save(User user) throws JsonProcessingException
    {
        // 获取Jedis链接
        Jedis jedis = JedisConnectionFactory.getJedis();
        // 选择数据库
        jedis.select(0);

        ObjectMapper objectMapper = new ObjectMapper();
        String result = jedis.set(user.getName(), objectMapper.writeValueAsString(user));

        // 关闭链接
        JedisConnectionFactory.close(jedis);

        return result;
    }

    @Override
    public User get(String name) throws JsonProcessingException
    {
        // 获取Jedis链接
        Jedis jedis = JedisConnectionFactory.getJedis();
        // 选择数据库
        jedis.select(0);

        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = jedis.get(name);
        User user = objectMapper.readValue(userJson, User.class);

        // 关闭链接
        JedisConnectionFactory.close(jedis);

        return user;
    }
}
