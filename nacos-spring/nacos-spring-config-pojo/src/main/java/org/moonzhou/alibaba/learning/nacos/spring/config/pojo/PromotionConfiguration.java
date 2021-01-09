package org.moonzhou.alibaba.learning.nacos.spring.config.pojo;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.moonzhou.alibaba.learning.nacos.spring.config.pojo.model.Promotion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "192.168.85.1:8848"))
public class PromotionConfiguration {

    @Bean
    public Promotion promotion() {
        return new Promotion();
    }

}