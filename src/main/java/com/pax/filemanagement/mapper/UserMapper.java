package com.pax.filemanagement.mapper;

import com.pax.filemanagement.dao.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @Author: Shawn
 * @Date: 2019/3/17 15:13
 */

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user_info WHERE user_id = #{user_id}")
    List<UserInfo> findByUserId(@Param("userId") String userId);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(UserInfo userInfo);

}
