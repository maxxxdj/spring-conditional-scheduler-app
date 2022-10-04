package com.example.springdemo;

import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ConditionalScheduler {

    private final ConfigLoad configs;

    public ConditionalScheduler(final ConfigLoad configs){
        this.configs = configs;
    }

    @SneakyThrows
    @Scheduled(fixedDelayString = "1000")
    @ConditionalOnBean(ConfigLoad.class)
    public void doJob(){
        if(configs.getIsLoaded()) {
            System.out.println("Loaded!");
        } else {
            Thread.sleep(5000);
            System.out.println("Still loading...!");
        }
    }
}