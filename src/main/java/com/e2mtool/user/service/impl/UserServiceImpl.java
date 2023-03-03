package com.e2mtool.user.service.impl;

import com.e2mtool.user.entity.User;
import com.e2mtool.user.mapper.UserMapper;
import com.e2mtool.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.getUser(user);
    }
}
