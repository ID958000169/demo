package org.zgy.demo.redis.springdataredis.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zgy.demo.redis.springdataredis.dto.Response;
import org.zgy.demo.redis.springdataredis.dto.ResponseUtil;
import org.zgy.demo.redis.springdataredis.dto.config.StatusCode;

@RestControllerAdvice
public class ExceptionHandlerConfig
{
    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception e)
    {
        return ResponseUtil.failure(StatusCode.SC500.getStatusCode(), StatusCode.SC500.getMessage());
    }
}
