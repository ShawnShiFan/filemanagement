package com.pax.filemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.dto.UserInfoDTO;
import com.pax.filemanagement.enums.ResultEnum;
import com.pax.filemanagement.mapper.UserMapper;
import com.pax.filemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 10:57
 * @Version 1.0
 */
@Service
@Transactional
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
    public List<UserInfoDTO> findList(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        return   userMapper.findAll();

    }

    @Override
    public UserInfoDTO findById(String userId) {
      UserInfoDTO userInfoDTO = userMapper.findByUserId(userId);
      return  userInfoDTO ;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addUser(UserInfoDTO userInfoDTO) {
        return   userMapper.insert(userInfoDTO);

    }

    @Override
    public List<UserInfoDTO> selectLikeName(String userName) {
        return userMapper.SelectLikeName(userName);
    }

    @Override
    public int deleteUserInfo(String userId) {
       UserInfoDTO userInfoDTO = userMapper.findByUserId(userId);
        if (userInfoDTO == null){
            return  ResultEnum.USER_NOT_EXIST.getCode();
        }else{
            return userMapper.deleteById(userId);
        }
    }

    @Override
    public List<UserInfoDTO> findBySex(Integer userSex) {
        return userMapper.findBySex(userSex);
    }
}
