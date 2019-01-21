package com.app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class AppsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppsApplication.class, args);
    }

}

