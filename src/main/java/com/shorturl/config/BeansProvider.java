package com.shorturl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Component
public class BeansProvider {

    @Bean(name = "MessageDigest")
    public MessageDigest md5instance() throws Exception    {
        return MessageDigest.getInstance("MD5");
    }
}
