package org.zgy.demo.redis.springdataredis.dto.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode
{
    SC100(100, "Success"),
    SC500(500, "Internal Server Error");

    private final int statusCode;
    private final String message;
}

