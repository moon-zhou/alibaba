/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NacosConfiguration.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/23 22:18
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.spring.discovery.provider.config;

/**
 * 功能描述: 注册服务<br>
 *     此方式参考：https://blog.csdn.net/yangshuxing1989/article/details/107912215
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@EnableNacos(globalProperties = @NacosProperties(serverAddr = "192.168.85.1:8848"))
public class NacosConfiguration {

    @NacosInjected
    private NamingService namingService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${nacos.discovery.server-addr}")
    private String serverAddr;

    @PostConstruct
    public void init() throws NacosException {
        //namingService.registerInstance(applicationName, serverAddr, serverPort);
    }
}
