package org.zgy.demo.redis.springdataredis.service;

import org.zgy.demo.redis.springdataredis.dto.SMSVerificationCodeRequest;

import javax.servlet.http.HttpSession;

public interface AuthenticationService
{
    String getSMSVerificationCode(SMSVerificationCodeRequest request, HttpSession session);
}
