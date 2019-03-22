package com.pax.filemanagement.controller;

import com.github.pagehelper.PageHelper;
import com.pax.filemanagement.VO.ResultVO;
import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.dto.UserInfoDTO;
import com.pax.filemanagement.service.UserService;
import com.pax.filemanagement.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 13:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {
    @Autowired
    private UserService userService;
    @GetMapping("/{userId}")
    public UserInfoDTO findOne(@PathVariable (value = "userId",required = true) String userId){
        return userService.findById(userId);

    }
    @GetMapping("/findAll")
    public List<UserInfoDTO> findAll(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                     @RequestParam(name = "pageSize",required = false,defaultValue = "1")int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        return  userService.findList(pageNum,pageSize);

    }

    @PostMapping("/add")
    @ResponseBody
    public int addUser(UserInfoDTO user){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        String userId = KeyUtil.genUniqueKey();
        userInfoDTO.setUserId(userId);
        userInfoDTO.setUserName(user.getUserName());
        userInfoDTO.setUserSex(user.getUserSex());
        userInfoDTO.setUserBirth(user.getUserBirth());
        userInfoDTO.setUserPhone(user.getUserPhone());
        userInfoDTO.setUserBirthAddress(user.getUserBirthAddress());
        userInfoDTO.setUserPhoto(user.getUserPhoto());
        Date date = new Date();
        System.out.println(date);
        userInfoDTO.setCreateTime(date);
        userInfoDTO.setUpdateTime(date);

        return userService.addUser(userInfoDTO);
    }

    @PostMapping("/like")
    public List<UserInfoDTO> selectLikeName(@RequestParam(value = "userName",required = true)String userName){
        return userService.selectLikeName(userName);

    }

    @GetMapping("/find/sex")
    public List<UserInfoDTO> findBySex(@RequestParam(value = "userSex",required = true)Integer userSex){
        return userService.findBySex(userSex);
    }

    @GetMapping("/userBirth")
    public ResultVO  findByUserBirth(@RequestParam(value = "userBirthStart") String userBirthStart,
                                              @RequestParam(value="userBirthEnd") String userBirthEnd ){



        return userService.findByUserBirth(userBirthStart,userBirthEnd);



    }


}

