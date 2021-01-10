package org.moonzhou.alibaba.learning.nacos.spring.config.service;

import org.moonzhou.alibaba.learning.nacos.spring.config.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findById(Integer id);
}