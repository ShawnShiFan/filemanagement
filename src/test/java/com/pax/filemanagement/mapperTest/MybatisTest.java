package com.pax.filemanagement.mapperTest;

import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Shawn
 * @Date: 2019/3/17 16:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisTest {
    @Autowired
   // private UserMapper userMapper;

    @Test
    public void test(){
        final int row =userMapper.insert(new UserInfo());
    }



}
