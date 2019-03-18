package com.pax.filemanagement.mapperTest;

import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/17 16:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("7");
        userInfo.setUserName("Sha7wn");
        userInfo.setUserSex(0);
        userInfo.setUserBirth("19977");
        userInfo.setUserPhone("132427423423");
        userInfo.setUserBirthAddress("江7苏");
        userInfo.setUserPhoto("file/e/1/2");
        Date date = new Date();
        userInfo.setCreateTime(date);
        userInfo.setUpdateTime(date);
        final int row =userMapper.insert(userInfo);

        log.info("【插入数据】,result={}",row);

        final List<UserInfo> userInfos = userMapper.findByUserId("1");
        log.info("【查找数据】： result={}",userInfos);
    }





}
