package com.pax.filemanagement.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * User实体类
 * @Author: Shawn
 * @Date: 2019/3/17 14:21
 */
@Data
@Entity
public class UserInfo {
    /**    用户id*/
    @Id
    private String  userId;
    /**    用户姓名*/
    private  String userName;
    /**    用户性别*/
    private Integer userSex;
    /**    用户出生日期*/
    private String userBirth;
    /**    用户电话*/
    private  String  userPhone;
    /**    用户出生地址*/
    private String userBirthAddress;
    /**    用户照片*/
    private String userPhoto;
    /**    创建时间*/
    private Date createTime;
    /**    更新时间*/
    private Date updateTime;




}
