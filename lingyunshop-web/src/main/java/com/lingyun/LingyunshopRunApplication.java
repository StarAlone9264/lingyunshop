package com.lingyun;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Star
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
public class LingyunshopRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(LingyunshopRunApplication.class, args);
    }
}
