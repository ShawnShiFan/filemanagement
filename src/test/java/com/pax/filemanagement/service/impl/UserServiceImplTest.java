package com.pax.filemanagement.service.impl;

import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.enums.ResultEnum;
import com.pax.filemanagement.mapper.UserMapper;
import com.pax.filemanagement.service.UserService;
import com.pax.filemanagement.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 14:22
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void findList() {

       log.info("【所有用户信息列表】：result={}",userService.findList(1,2));
    }

    @Test
    public void findById() {
        List<UserInfo> userInfo = userService.findById("1");
        log.info("【查找用户】： result={}",userInfo);
    }

    @Test
    public void addUser() {
        UserInfo userInfo = new UserInfo();
        String userId = KeyUtil.genUniqueKey();
        userInfo.setUserId(userId);
        userInfo.setUserName("huanziq");
        userInfo.setUserSex(0);
        userInfo.setUserBirth("19977");
        userInfo.setUserPhone("132427423423");
        userInfo.setUserBirthAddress("江7苏");
        userInfo.setUserPhoto("file/e/1/2");
        Date date = new Date();
        userInfo.setCreateTime(date);
        userInfo.setUpdateTime(date);
        int row =userService.addUser(userInfo);

        log.info("【插入数据】,result={}",row);

    }

    @Test
    public void selectLike() {
        List<UserInfo> result = userService.selectLikeName("S");
        log.info("【按姓名模糊查找】,result={}",result);
    }

    @Test
    public void  deleteById(){

        Integer result = userService.deleteUserInfo("9");
        if (result == ResultEnum.USER_NOT_EXIST.getCode()){
            log.info("【用户不存在】");
        }else if (result == 1){
            log.info("【删除用户信息成功】");
        }else if (result==0){
            log.info("【删除失败】");
        }
    }

    @Test
    public void findBySex() {
        userService.findBySex(0);
    }
}