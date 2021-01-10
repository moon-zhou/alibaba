package org.moonzhou.alibaba.learning.nacos.spring.config.controller;

import org.moonzhou.alibaba.learning.nacos.spring.config.model.User;
import org.moonzhou.alibaba.learning.nacos.spring.config.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    /**
     * http://localhost:8080/nacos_spring_config_datasource_war/user?id=1
     * @param id
     * @return
     */
    @RequestMapping
    @ResponseBody
    public User get(@RequestParam int id) {
        return userService.findById(id);
    }

}