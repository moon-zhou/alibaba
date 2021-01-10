package org.moonzhou.alibaba.learning.nacos.spring.config.controller;

import org.moonzhou.alibaba.learning.nacos.spring.config.model.Admin;
import org.moonzhou.alibaba.learning.nacos.spring.config.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author moon zhou
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * http://localhost:8080/nacos_spring_config_listener_war/admin
     * @return
     */
    @RequestMapping(method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Admin get() {
        return adminService.getAdmin();
    }
}

