package org.moonzhou.alibaba.learning.nacos.spring.config.converter;

import com.alibaba.nacos.api.config.convert.NacosConfigConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.moonzhou.alibaba.learning.nacos.spring.config.model.Admin;

/**
 * @author moon zhou
 */
public class AdminConverter implements NacosConfigConverter<Admin> {

    @Override
    public boolean canConvert(Class targetType) {
        return Admin.class.equals(targetType);
    }

    /**
     * 可自定义转化格式
     */
    @Override
    public Admin convert(String config) {
        // 原示例里面，没有显示的引入fastjson，是通过nacos-spring-context-->nacos-client-->nacos-api-->fastjson
        // 而本示例里，使用的nacos-spring-context已经不使用fastjson，转而使用了jackson，本处代码也做相应的修改，使用jackson处理
        // return JSON.parseObject(config, Admin.class);

        Admin admin = null;

        try {
            admin = new ObjectMapper().readValue(config, Admin.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return admin;
    }
}