/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NacosProvider005.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/2/2 14:39
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.discovery;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

/**
 * 功能描述: nacos java 取消监听<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NacosProvider006 {
    public static void main(String[] args) throws NacosException {
        String serverAddr = "192.168.85.1:8848";
        NamingService naming = NamingFactory.createNamingService(serverAddr);


        naming.unsubscribe("nacos-sdk-java-discovery", event -> {});
    }
}
