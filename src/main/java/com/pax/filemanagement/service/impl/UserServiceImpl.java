package com.pax.filemanagement.service.impl;

import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.mapper.UserMapper;
import com.pax.filemanagement.service.UserService;
import com.pax.filemanagement.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 10:57
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserInfo> findList() {
        return   userMapper.findAll();

    }

    @Override
    public List<UserInfo> findById(String userId) {

        return  userMapper.findByUserId(userId);
    }
}
