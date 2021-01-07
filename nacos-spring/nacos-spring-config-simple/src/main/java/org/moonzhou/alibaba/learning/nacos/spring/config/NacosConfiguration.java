package org.moonzhou.alibaba.learning.nacos.spring.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableNacosConfig(readConfigTypeFromDataId = false, globalProperties = @NacosProperties(serverAddr = "192.168.85.1:8848"))
/**
 * Document: https://nacos.io/zh-cn/docs/quick-start-spring.html
 * <p>
 * Nacos 控制台添加配置：
 * <p>
 * Data ID：example
 * <p>
 * Group：DEFAULT_GROUP
 * <p>
 * 配置内容：useLocalCache=true
 */
@NacosPropertySource(dataId = "moon-nacos-config", autoRefreshed = true, type = ConfigType.YAML)
public class NacosConfiguration {

}