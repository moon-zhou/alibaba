package org.moonzhou.alibaba.learning.nacos.spring.cloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    /**
     * 对应nacos server里的配置内容，yml格式的
     * dataId： <code>${prefix}-${spring.profiles.active}.${file-extension}</code>
     *     prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
     * group: DEFAULT_GROUP
     *
     * RefreshScope自动刷新，监听服务端的配置修改
     */
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    /**
     * http://localhost:8090/config/get
     * http://192.168.1.6/:8090/config/get
     */
    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}