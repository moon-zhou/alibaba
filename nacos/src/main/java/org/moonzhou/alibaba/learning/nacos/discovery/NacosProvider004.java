/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NacosProvider004.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/29 17:36
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.discovery;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

/**
 * 功能描述: nacos java 选择一个服务<br>
 *
 *     因为注册的是不存在的服务，所以healthy设置为false
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NacosProvider004 {

    public static void main(String[] args) throws NacosException {

        String serverAddr = "192.168.85.1:8848";
        NamingService naming = NamingFactory.createNamingService(serverAddr);

        System.out.println();
        System.out.println(naming.selectInstances("nacos-sdk-java-discovery", false));
        System.out.println();

        System.out.println(naming.selectOneHealthyInstance("nacos-sdk-java-discovery"));
    }
}
