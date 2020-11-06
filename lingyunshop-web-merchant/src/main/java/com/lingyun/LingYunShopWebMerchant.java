package com.lingyun;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/28 15:42
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
public class LingYunShopWebMerchant {
    public static void main(String[] args) {
        SpringApplication.run(LingYunShopWebMerchant.class,args);
    }
}
