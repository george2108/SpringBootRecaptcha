package com.recaptcha.services.impl;

import com.recaptcha.controllers.response.RecaptchaResponse;
import com.recaptcha.services.RecaptchaService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RecaptchaServiceImpl implements RecaptchaService {
    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
    private final String RECAPTCHA_SECRET = "6LcXhkgpAAAAABiPAN-bY1pRF7WbH7Y0EUMJMKz4";

    @Override
    public boolean validateRecaptcha(String captchaResponse) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("secret", RECAPTCHA_SECRET);
        request.add("response", captchaResponse);
        RecaptchaResponse apiResponse = restTemplate.postForObject(
                GOOGLE_RECAPTCHA_ENDPOINT,
                request,
                RecaptchaResponse.class
        );

        if (apiResponse == null) {
            return false;
        }

        return Boolean.TRUE.equals(apiResponse.getSuccess());
    }
}
