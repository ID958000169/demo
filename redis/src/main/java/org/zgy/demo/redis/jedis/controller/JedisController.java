package org.zgy.demo.redis.jedis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zgy.demo.redis.jedis.entity.User;
import org.zgy.demo.redis.jedis.service.JedisService;

@RestController
@RequestMapping("/jedis")
public class JedisController
{
    @Autowired
    private JedisService jedisService;

    /*
     * URL: http://localhost:8080/jedis/save
     */
    @GetMapping("/save")
    public void save() throws JsonProcessingException
    {
        User user = new User("gavin", 18);
        jedisService.save(user);
    }

    /*
     * URL: http://localhost:8080/jedis/get
     */
    @GetMapping("/get")
    public User get() throws JsonProcessingException
    {
        User user = jedisService.get("gavin");
        return user;
    }
}
