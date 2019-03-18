package com.pax.filemanagement.service;

import org.springframework.data.domain.Page;
import com.pax.filemanagement.dao.UserInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 10:56
 * @Version 1.0
 */

public interface UserService {

    /** 查询用户列表*/
    List<UserInfo> findList();

    /** 查询单个用户列表*/
    List<UserInfo> findById(String userId);


}
