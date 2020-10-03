package com.jen.springsecurity.demo.dao;

import com.jen.springsecurity.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
