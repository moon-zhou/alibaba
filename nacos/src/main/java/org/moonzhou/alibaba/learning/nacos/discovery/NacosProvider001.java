/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NacosProvider001.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/29 16:16
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.discovery;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Cluster;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.Service;
import com.alibaba.nacos.api.naming.pojo.healthcheck.AbstractHealthChecker;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: nacos java 服务注册示例<br>
 * 因为注册的服务不一定真的存在，所以服务列表里，把空服务也打开，才能看到对应的注册数据
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NacosProvider001 {
    public static void main(String[] args) throws NacosException {

        /*NamingService namingService = NamingFactory.createNamingService(properties)
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);*/

        String serverAddr = "192.168.85.1:8848";
        NamingService naming = NamingFactory.createNamingService(serverAddr);
        naming.registerInstance("nacos-sdk-java-discovery", "127.0.0.1", 8848, "TEST1");

        Instance instance = new Instance();
        instance.setIp("55.55.55.55");
        instance.setPort(9999);
        instance.setHealthy(false);
        instance.setWeight(2.0);
        Map<String, String> instanceMeta = new HashMap<>();
        instanceMeta.put("site", "et2");
        instance.setMetadata(instanceMeta);

        naming.registerInstance("nacos-sdk-java-discovery2", instance);
    }
}
