/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: NacosClient004.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/21 18:17
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * 功能描述: 发布配置示例<br>
 *     通过代码将配置发布到Nacos服务里，以便通过自动化手段降低运维成本。
 *  
 *     <code>public boolean publishConfig(String dataId, String group, String content) throws NacosException</code>
 *
 *     <code>public boolean publishConfig(String dataId, String group, String content, String type) throws NacosException</code>
 *     Type: com.alibaba.nacos.api.config.ConfigType @Since 1.4.1
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NacosClient004 {

    public static void main(String[] args) {
        try {
            // 此地址不一定是127.0.0.1，按实际启动时终端显示的后台访问地址里的为准
//            String serverAddr = "http://192.168.1.4:8848";
            String serverAddr = "http://192.168.85.1:8848";

            String dataId = "testPublish";
            String group = "testGroup";

            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);

//            boolean isPublishOk = configService.publishConfig(dataId, group, "content");
            boolean isPublishOk = configService.publishConfig(dataId, group, "content=内容", String.valueOf(ConfigType.PROPERTIES));
            System.out.println("发布结果：" + isPublishOk);
        } catch (NacosException e) {

            // 读取配置超时或网络异常，抛出 NacosException 异常。
            e.printStackTrace();
        }
    }
}
