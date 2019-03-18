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
    List<UserInfo> findList(int pageNum,int pageSize);

    /** 查询单个用户列表*/
    List<UserInfo> findById(String userId);

    /** 新增用户*/
    int addUser(UserInfo userInfo);

    /** 根据姓名模糊查询*/
    List<UserInfo> selectLikeName(String userName);

    /**根据性别查询*/
    List<UserInfo> findBySex(Integer userSex);

    /**根据userId删除信息*/
    int deleteUserInfo(String userId);
}
