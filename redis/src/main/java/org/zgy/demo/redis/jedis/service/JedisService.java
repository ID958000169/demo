package org.zgy.demo.redis.jedis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.zgy.demo.redis.jedis.entity.User;

public interface JedisService
{
    public String save(User user) throws JsonProcessingException;

    public User get(String name) throws JsonProcessingException;
}
