/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NacosProvider002.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/29 17:25
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.discovery;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: nacos java 删除服务<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NacosProvider002 {
    public static void main(String[] args) throws NacosException {
        String serverAddr = "192.168.85.1:8848";
        NamingService naming = NamingFactory.createNamingService(serverAddr);
        naming.deregisterInstance("nacos-sdk-java-discovery", "127.0.0.1", 8848, "TEST1");

        Instance instance = new Instance();
        instance.setIp("55.55.55.55");
        instance.setPort(9999);
        instance.setHealthy(false);
        instance.setWeight(2.0);
        Map<String, String> instanceMeta = new HashMap<>();
        instanceMeta.put("site", "et2");
        instance.setMetadata(instanceMeta);
        naming.deregisterInstance("nacos-sdk-java-discovery2", instance);
    }
}
