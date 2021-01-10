package org.moonzhou.alibaba.learning.nacos.spring.config.pojo.controller;

import org.moonzhou.alibaba.learning.nacos.spring.config.pojo.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("promotion")
public class PromotionController {

    @Autowired
    private Promotion promotion;

    /**
     * http://localhost:8080/nacos_spring_config_pojo_war/promotion
     * @return
     */
    @RequestMapping(method = GET)
    @ResponseBody
    public Promotion get() {
        return promotion;
    }

}

