package org.moonzhou.alibaba.learning.nacos.spring.config.service.impl;

import org.moonzhou.alibaba.learning.nacos.spring.config.dao.UserMapper;
import org.moonzhou.alibaba.learning.nacos.spring.config.model.User;
import org.moonzhou.alibaba.learning.nacos.spring.config.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {this.userMapper = userMapper;}

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}