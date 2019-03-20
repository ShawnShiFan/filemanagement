package com.pax.filemanagement.mapperTest;

import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.dto.UserInfoDTO;
import com.pax.filemanagement.mapper.UserMapper;
import com.pax.filemanagement.utils.KeyUtil;
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
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        String userId = KeyUtil.genUniqueKey();
        userInfoDTO.setUserId(userId);
        userInfoDTO.setUserName("huanziq");
        userInfoDTO.setUserSex(0);
        userInfoDTO.setUserBirth("19977");
        userInfoDTO.setUserPhone("132427423423");
        userInfoDTO.setUserBirthAddress("江7苏");
        userInfoDTO.setUserPhoto("file/e/1/2");
        Date date = new Date();
        userInfoDTO.setCreateTime(date);
        userInfoDTO.setUpdateTime(date);
        final int row =userMapper.insert(userInfoDTO);

        log.info("【插入数据】,result={}",row);

        final UserInfoDTO userInfoDTOs = userMapper.findByUserId("1");
        log.info("【查找数据】： result={}",userInfoDTOs);
    }





}
