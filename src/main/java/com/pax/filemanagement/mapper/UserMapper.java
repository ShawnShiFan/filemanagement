package com.pax.filemanagement.mapper;


import com.pax.filemanagement.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/17 15:13
 */

@Mapper
public interface UserMapper {

    /** 根据userId查询的单条记录*/
    @Select("SELECT * FROM user_info WHERE user_id = #{userId}")
    UserInfoDTO findByUserId(@Param("userId") String userId);

    @Select("SELECT * FROM user_info")
    List<UserInfoDTO> findAll();

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(UserInfoDTO userInfoDTO);

    /**按姓名模糊查询*/
    List<UserInfoDTO> SelectLikeName(String userName);

    /**修改用户信息*/
    int updateInfo(UserInfoDTO userInfoDTO);

    /**根据性别查询*/
    @Select("SELECT * FROM user_info WHERE user_sex = #{userSex}")
    List<UserInfoDTO> findBySex(@Param("userSex") Integer userSex);

    /**根据userId删除信息*/
   int deleteById(String userId);

    /** 根据选择删除用户信息*/
    int deleteSelect();

    /** 根据出生日期范围返回用户信息*/
    List<UserInfoDTO> findByUserBirth(Date userBirthStart, Date userBirthEnd);

}
