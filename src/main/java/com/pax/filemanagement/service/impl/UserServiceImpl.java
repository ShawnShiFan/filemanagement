package com.pax.filemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.pax.filemanagement.VO.ResultVO;
import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.dto.UserInfoDTO;
import com.pax.filemanagement.enums.ResultEnum;
import com.pax.filemanagement.mapper.UserMapper;
import com.pax.filemanagement.service.UserService;
import com.pax.filemanagement.utils.ResultVOUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 10:57
 * @Version 1.0
 */
@Service
@Transactional
@Slf4j
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

    @Override
    public ResultVO findByUserBirth(String userBirthStart, String userBirthEnd) {
        //TODO 更改前后端参数一致 当前默认传入的为String 由后台进行转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date timeStart = sdf.parse(userBirthStart);
            Date timeEnd = sdf.parse(userBirthEnd);
            ResultVO resultVO =new ResultVO();
            resultVO.setData(userMapper.findByUserBirth(timeStart,timeEnd));
            resultVO.setCode(ResultEnum.PARAM_CORRECT.getCode());
            resultVO.setMsg(ResultEnum.PARAM_CORRECT.getMessage());
            return  resultVO;
        } catch (ParseException e) {
            log.info("【传入参数不正确】");
        }
        ResultVO resultVO =new ResultVO();
        resultVO.setCode(ResultEnum.PARAM_INPUT_ERROR.getCode());
        resultVO.setMsg(ResultEnum.PARAM_INPUT_ERROR.getMessage());

        return resultVO;


    }
}
