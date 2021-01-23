package org.moonzhou.alibaba.learning.nacos.spring.discovery.consumer;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "192.168.85.1:8848"))
public class NacosConfiguration {

}