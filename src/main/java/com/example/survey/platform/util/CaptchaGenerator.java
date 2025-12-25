package com.example.survey.platform.util;

import java.util.Random;

public class CaptchaGenerator {

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 生成指定长度的随机验证码
     */
    public static String generateCaptcha(int length) {
        Random random = new Random();
        StringBuilder captcha = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            captcha.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
        }
        return captcha.toString();
    }
}
