package com.pax.filemanagement.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @Author: Shawn
 * @Date: 2019/3/20 16:34
 * @Version 1.0
 */
@Data
public class UserInfoDTO {
    /**    用户id*/
    @Id
    @NotEmpty
    private String  userId;

    /**    用户姓名*/
    @NotEmpty
    private  String userName;

    /**    用户性别*/
    @NotEmpty
    private Integer userSex;

    /**    用户出生日期*/
    @NotEmpty
    private String userBirth;

    /**    用户电话*/
    @NotEmpty
    private  String  userPhone;

    /**    用户出生地址*/
    @NotEmpty
    private String userBirthAddress;

    /**    用户照片*/
    @NotEmpty
    private String userPhoto;

    /**    创建时间*/
    @NotEmpty
    private Date createTime;

    /**    更新时间*/
    @NotEmpty
    private Date updateTime;
}
