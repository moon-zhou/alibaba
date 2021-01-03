/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NacosConfigDefault.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/3 21:57
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.spring.boot.config.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
@NacosPropertySource(dataId = "moon-nacos-config", autoRefreshed = true)
public class NacosConfigDefault {
}
