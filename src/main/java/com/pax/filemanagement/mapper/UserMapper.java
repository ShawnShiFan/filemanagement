package com.pax.filemanagement.mapper;

import com.pax.filemanagement.dao.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.awt.print.Pageable;
import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/17 15:13
 */

@Mapper
public interface UserMapper {

    /** 根据userId查询的单条记录*/
    @Select("SELECT * FROM user_info WHERE user_id = #{userId}")
    List<UserInfo> findByUserId(@Param("userId") String userId);

    @Select("SELECT * FROM user_info")
    List<UserInfo> findAll();

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(UserInfo userInfo);

}
