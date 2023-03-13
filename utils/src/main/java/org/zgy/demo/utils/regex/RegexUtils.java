package org.zgy.demo.utils.regex;

import java.util.regex.Pattern;

public class RegexUtils
{
    /**
     * 校验手机号码是否有效
     */
    public static boolean isPhoneInvalid(String phoneNumber)
    {
        return isMatched(RegexPatterns.PHONE_REGEX, phoneNumber);
    }

    /**
     * 校验邮箱是否有效
     */
    public static boolean isEmailInvalid(String email)
    {
        return isMatched(RegexPatterns.EMAIL_REGEX, email);
    }

    public static boolean isMatched(String pattern, String content)
    {
        return Pattern.matches(pattern, content);
    }
}
