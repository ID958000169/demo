package org.zgy.demo.redis.springdataredis.dto.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.zgy.demo.redis.springdataredis.dto.Response;
import org.zgy.demo.redis.springdataredis.dto.ResponseUtil;

@RestControllerAdvice
public class ResponseBodyAdviceCustomization implements ResponseBodyAdvice
{
    @Override
    public boolean supports(MethodParameter returnType, Class converterType)
    {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response)
    {
        return body instanceof Response ? body : ResponseUtil.success(body);
    }
}
