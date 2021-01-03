/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NacosServerUserConfig.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/3 11:11
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.spring.boot.config.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 功能描述:<br>
 *        <p>
 *        Nacos 控制台添加配置：
 *        <p>
 *        Data ID：example
 *        <p>
 *        Group：DEFAULT_GROUP
 *        <p>
 *        配置内容：useLocalCache=true
 *
 * 此处使用<code>@Component</code>，而不能使用<code>@Configuration</code>，否则自动刷新将无法使用
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
//@Configuration
@Component
@NacosPropertySource(groupId = "nacos-example", dataId = "nacos-spring-boot-user-config", autoRefreshed = true)
public class NacosServerUserConfig {

    @NacosValue(value = "${name:noname}", autoRefreshed = true)
    private String name;

    @NacosValue(value = "${age:1}", autoRefreshed = true)
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
