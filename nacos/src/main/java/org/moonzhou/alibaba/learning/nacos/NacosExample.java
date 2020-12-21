package org.moonzhou.alibaba.learning.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.listener.impl.PropertiesListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
/**
 * 示例代码，仅用于示例测试，带有监听
 * 
 * 官网示例：https://www.alibabacloud.com/help/zh/doc-detail/94562.htm
 *
 * @author moonzhou
 */
public class NacosExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(NacosExample.class);
    public static void main(String[] args) throws NacosException {
        Properties properties = new Properties();
        // 指定配置的 DataID 和 Group
        String dataId = "${dataId}";
        String group = "${group}";
        String content = "connectTimeoutInMills=5000";
        // 从控制台命名空间管理的"命名空间详情"中拷贝 endpoint、namespace 
        properties.put(PropertyKeyConst.ENDPOINT, "${endpoint}");
        properties.put(PropertyKeyConst.NAMESPACE, "${namespace}");
         // 通过 ECS 实例 RAM 角色访问 ACM
         // properties.put("ramRoleName", "$ramRoleName");
        properties.put(PropertyKeyConst.ACCESS_KEY, "${accessKey}");
        properties.put(PropertyKeyConst.SECRET_KEY, "${secretKey}");
        ConfigService configService = NacosFactory.createConfigService(properties);
        // 发布配置
        boolean publishConfig = configService.publishConfig(dataId, group, content);
        LOGGER.info("publishConfig: {}", publishConfig);
        wait2Sync();
        // 查询配置
        String config = configService.getConfig(dataId, group, 5000);
        LOGGER.info("getConfig: {}", config);
        // 监听配置
        configService.addListener(dataId, group, new PropertiesListener() {
            @Override
            public void innerReceive(Properties properties) {
                LOGGER.info("innerReceive: {}", properties);
            }
        });
        // 更新配置
        boolean updateConfig = configService.publishConfig(dataId, group, "connectTimeoutInMills=3000");
        LOGGER.info("updateConfig: {}", updateConfig);
        wait2Sync();
        // 删除配置
        boolean removeConfig = configService.removeConfig(dataId, group);
        LOGGER.info("removeConfig: {}", removeConfig);
        wait2Sync();
        config = configService.getConfig(dataId, group, 5000);
        LOGGER.info("getConfig: {}", config);
    }
    private static void wait2Sync() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}