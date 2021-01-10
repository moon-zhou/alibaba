package org.moonzhou.alibaba.learning.nacos.spring.config.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.moonzhou.alibaba.learning.nacos.spring.config.model.User;

public interface UserMapper {

    @Select(value = "select id, name from user where id = #{id}")
    User findById(@Param("id") long id);
}