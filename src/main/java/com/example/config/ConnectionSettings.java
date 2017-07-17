package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="connection")
public class ConnectionSettings
{
    private String alloworigin_cors_a;

    public String getAlloworigin_cors_a()
    {
        return alloworigin_cors_a;
    }

    public void setAlloworigin_cors_a(String alloworigin_cors_a)
    {
        this.alloworigin_cors_a = alloworigin_cors_a;
    }
}
