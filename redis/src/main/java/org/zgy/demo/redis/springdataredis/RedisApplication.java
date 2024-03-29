package org.zgy.demo.redis.springdataredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication
{
    private static final Logger logger = LoggerFactory.getLogger(RedisApplication.class);
    public static void main(String[] args)
    {
        logger.info("Application start begin.");
        SpringApplication.run(RedisApplication.class, args);
        logger.info("Application start complete.");
    }
}
