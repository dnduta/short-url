package com.shorturl.config;

import com.shorturl.resources.ShortenUrl;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.shorturl");
        register(ShortenUrl.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}
