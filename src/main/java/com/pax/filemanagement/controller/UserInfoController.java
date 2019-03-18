package com.pax.filemanagement.controller;

import com.github.pagehelper.PageHelper;
import com.pax.filemanagement.VO.ResultVO;
import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.service.UserService;
import com.pax.filemanagement.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 13:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {
    @Autowired
    private UserService userService;
    @GetMapping("/findOne")
    public List<UserInfo> findOne(@RequestParam(value = "userId",required = true) String userId){
        return userService.findById(userId);

    }
    @GetMapping("/findAll")
    public List<UserInfo> findAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                  @RequestParam(name = "pageSize",required = false,defaultValue = "1")int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        return  userService.findList(pageNum,pageSize);

    }

    @PostMapping("/add")
    public int addUser(@RequestParam(value = "userName",required = true)String userName,
                       @RequestParam(value = "userId",required = true)int userSex,
                       @RequestParam(value = "userBirth",required = true)String userBirth,
                       @RequestParam(value = "userPhone",required = true)String userPhone,
                       @RequestParam(value = "userBirthAddress",required = true)String userBirthAddress,
                       @RequestParam(value = "userPhoto",required = true)String userPhoto,
                       @RequestParam(value = "createTime",required = true)Date createTime,
                       @RequestParam(value = "updateTime",required = true) Date updateTime){
        UserInfo userInfo = new UserInfo();
        String userId = KeyUtil.genUniqueKey();
        userInfo.setUserId(userId);
        userInfo.setUserName(userName);
        userInfo.setUserSex(userSex);
        userInfo.setUserBirth(userBirth);
        userInfo.setUserPhone(userPhone);
        userInfo.setUserBirthAddress(userBirthAddress);
        userInfo.setUserPhoto(userPhoto);
        Date date = new Date();
        userInfo.setCreateTime(date);
        userInfo.setUpdateTime(date);

        return userService.addUser(userInfo);
    }

    @PostMapping("/like")
    public List<UserInfo> selectLikeName(@RequestParam(value = "userName",required = true)String userName){
        return userService.selectLikeName(userName);

    }

    @GetMapping("/find/sex")
    public List<UserInfo> findBySex(@RequestParam(value = "userSex",required = true)Integer userSex){
        return userService.findBySex(userSex);
    }


}

