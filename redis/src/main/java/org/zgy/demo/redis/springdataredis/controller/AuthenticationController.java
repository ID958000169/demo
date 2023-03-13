package org.zgy.demo.redis.springdataredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zgy.demo.redis.springdataredis.dto.SMSVerificationCodeRequest;
import org.zgy.demo.redis.springdataredis.service.AuthenticationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/getSMSVerifCode")
    @ResponseBody
    public String getSMSVerificationCode(@RequestBody @Valid SMSVerificationCodeRequest request, HttpSession session)
    {
        return authenticationService.getSMSVerificationCode(request, session);
    }
}
