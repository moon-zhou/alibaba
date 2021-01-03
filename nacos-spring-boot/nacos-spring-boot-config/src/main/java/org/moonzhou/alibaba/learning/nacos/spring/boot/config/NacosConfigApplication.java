package org.moonzhou.alibaba.learning.nacos.spring.boot.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Document: https://nacos.io/zh-cn/docs/quick-start-spring-boot.html
 */
@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(org.moonzhou.alibaba.learning.nacos.spring.boot.config.NacosConfigApplication.class, args);
    }
}