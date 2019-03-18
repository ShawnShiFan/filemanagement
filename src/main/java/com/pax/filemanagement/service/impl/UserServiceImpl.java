package com.pax.filemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.enums.ResultEnum;
import com.pax.filemanagement.mapper.UserMapper;
import com.pax.filemanagement.service.UserService;
import com.pax.filemanagement.utils.KeyUtil;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
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


    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     **/
    @Override
    public List<UserInfo> findList(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        return   userMapper.findAll();

    }

    @Override
    public List<UserInfo> findById(String userId) {

        return  userMapper.findByUserId(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addUser(UserInfo userInfo) {
        return   userMapper.insert(userInfo);

    }

    @Override
    public List<UserInfo> selectLikeName(String userName) {
        return userMapper.SelectLikeName(userName);
    }

    @Override
    public int deleteUserInfo(String userId) {
        List<UserInfo> userInfo = userMapper.findByUserId(userId);
        if (userInfo == null){
            return  ResultEnum.USER_NOT_EXIST.getCode();
        }else{
            return userMapper.deleteById(userId);
        }
    }

    @Override
    public List<UserInfo> findBySex(Integer userSex) {
        return userMapper.findBySex(userSex);
    }
}
