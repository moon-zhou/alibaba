/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: NacosTest.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/16 18:13
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.moonzhou.alibaba.learning.nacos.bean.ListenerConf;
import org.moonzhou.alibaba.learning.nacos.util.PropertyUtils;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 功能描述: nacos测试，获取配置信息<br>
 *     添加监听，同时测试移除监听
 *     <code>public void addListener(String dataId, String group, Listener listener) </code>
 *     <code>public void removeListener(String dataId, String group, Listener listener)</code>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NacosClient003 {

    // 缓存配置数据对象
    private static Properties newConfProperties;

    /**
     * 移除监听标志位
     */
    private static String LISTENER_OFF = "off";

    /**
     * 移除Listener标志位
     */
    private static boolean REMOVE_FLAG;

    public static void main(String[] args) {
        try {
            // 此地址不一定是127.0.0.1，按实际启动时终端显示的后台访问地址里的为准
            String serverAddr = "http://192.168.1.4:8848";
//            String serverAddr = "http://192.168.85.1:8848";

            String dataId = "testListener";
            String group = "testGroup";

            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);

            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
            loadContent(content);

            Listener listener = new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("recieve1:" + configInfo);
                    loadContent(configInfo);
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            };
            configService.addListener(dataId, group, listener);

            // 测试让主线程不退出，因为订阅配置是守护线程，主线程退出守护线程就会退出。 正式代码中无需下面代码
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("----------------------------------------");
                System.out.println(ListenerConf.listenerContent);
                System.out.println(ListenerConf.listenerSwitch);
                System.out.println(REMOVE_FLAG);

                if (!REMOVE_FLAG && LISTENER_OFF.equals(ListenerConf.listenerSwitch)) {
                    System.out.println("-----------remove listener...");
                    REMOVE_FLAG = true;
                    configService.removeListener(dataId, group, listener);
                }

            }
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    private static void loadContent(String configInfo) {
        // 将配置内容从String转换成结构化数据
        StringReader stringReader = new StringReader(configInfo);
        newConfProperties = new Properties();
        try {
            newConfProperties.load(stringReader);

            PropertyUtils.toObj(newConfProperties, ListenerConf.class);

            System.out.println(ListenerConf.listenerContent);
            System.out.println(ListenerConf.listenerSwitch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
