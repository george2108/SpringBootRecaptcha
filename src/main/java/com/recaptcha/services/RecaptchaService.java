package com.recaptcha.services;

public interface RecaptchaService {
    boolean validateRecaptcha(String captchaResponse);
}
