package org.zgy.demo.redis.springdataredis.dto;

import org.zgy.demo.redis.springdataredis.dto.config.StatusCode;

public class ResponseUtil<T>
{
    public static <T> Response<T> success(T data)
    {
        return new Response(StatusCode.SC100.getStatusCode(), StatusCode.SC100.getMessage(), data);
    }

    public static <T> Response<T> failure(int statusCode, String message)
    {
        return new Response(statusCode, message, null);
    }
}
