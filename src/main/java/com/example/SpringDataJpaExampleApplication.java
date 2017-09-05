package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.config.ConnectionSettings;

@SpringBootApplication
@EnableCaching
@Configuration
//@EnableAutoConfiguration(exclude={EndpointCorsProperties.class})
public class SpringDataJpaExampleApplication
{
    @Bean
    @ConfigurationProperties(prefix = "connection")
    public ConnectionSettings connectionSettings()
    {
        return new ConnectionSettings();

    }

    public static void main(String[] args)
    {
        SpringApplication.run(SpringDataJpaExampleApplication.class, args);
    }
}
