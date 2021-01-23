/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: ProviderListener.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/23 21:26
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.spring.discovery.provider.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 功能描述: 监听方法，在spring容器初始化完成后执行<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
@EnableNacos(globalProperties = @NacosProperties(serverAddr = "192.168.85.1:8848"))
public class ProviderListener implements ApplicationListener<ContextRefreshedEvent> {

    @NacosInjected
    private NamingService namingService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${nacos.discovery.server-addr}")
    private String serverAddr;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)  {

        // 通过Naming服务注册实例到注册中心
        try {
            namingService.registerInstance(applicationName, serverAddr, serverPort);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
