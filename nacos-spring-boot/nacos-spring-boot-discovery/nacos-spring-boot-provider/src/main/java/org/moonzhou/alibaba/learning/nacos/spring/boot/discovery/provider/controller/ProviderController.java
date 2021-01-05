/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: ProviderController.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/1/4 20:15
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.spring.boot.discovery.provider.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("service")
public class ProviderController {

    /**
     * http://10.19.38.5:9020/service/hello?name=moon
     * @param name
     * @return
     */
    @GetMapping(path = "/hello")
    @ResponseBody
    public String hello(@RequestParam(name = "name") String name) {
        return String.format("%s say hello!", name);
    }
}
