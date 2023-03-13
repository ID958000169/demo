package org.zgy.demo.redis.springdataredis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Valid
public class SMSVerificationCodeRequest implements Serializable
{
    private static final long serialVersionUID = 2136589772332267765L;

    @NotNull(message = "")
    @Size(min = 11, max = 11, message = "lenght have issue")
    private String phoneNumber;
}
