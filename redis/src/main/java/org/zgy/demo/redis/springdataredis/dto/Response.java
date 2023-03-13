package org.zgy.demo.redis.springdataredis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable
{
    private static final long serialVersionUID = -1905956179034742436L;
    private int statusCode;
    private String message;
    private T data;
}
