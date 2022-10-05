package com.example.springdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
public class ConfigLoad {

    private boolean isLoaded;

    @Bean
    void load(){
        this.isLoaded = true;
    }

    public boolean getIsLoaded(){
        return this.isLoaded;
    }
}