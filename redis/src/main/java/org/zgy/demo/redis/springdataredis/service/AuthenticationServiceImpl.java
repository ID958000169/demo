package org.zgy.demo.redis.springdataredis.service;

import org.springframework.stereotype.Service;
import org.zgy.demo.redis.springdataredis.dto.SMSVerificationCodeRequest;
import org.zgy.demo.utils.regex.RegexUtils;

import javax.servlet.http.HttpSession;

@Service
public class AuthenticationServiceImpl implements AuthenticationService
{
    @Override
    public String getSMSVerificationCode(SMSVerificationCodeRequest request, HttpSession session)
    {
        RegexUtils.isPhoneInvalid("");
        return null;
    }
}
