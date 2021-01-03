package org.moonzhou.alibaba.learning.nacos.spring.boot.config.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.moonzhou.alibaba.learning.nacos.spring.boot.config.config.NacosServerUserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @Autowired
    private NacosServerUserConfig nacosServerUserConfig;

    /**
     * http://192.168.1.6:9010/config/get
     * @return
     */
    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }

    /**
     * http://192.168.1.6:9010/config/getUser
     * @return
     */
    @RequestMapping(value = "/getUser", method = GET)
    @ResponseBody
    public Map getUser() {
        Map user = new HashMap();
        user.put("name", nacosServerUserConfig.getName());
        user.put("age", nacosServerUserConfig.getAge());

        return user;
    }
}