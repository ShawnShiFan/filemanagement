package com.pax.filemanagement.controller;

import com.pax.filemanagement.VO.ResultVO;
import com.pax.filemanagement.dao.UserInfo;
import com.pax.filemanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/findOne")
    public List<UserInfo> findOne(@RequestParam(value = "userId",required = true) String userId){
          return userService.findById(userId);

    }
    @GetMapping("/findAll")
    public List<UserInfo> findAll(){
       return  userService.findList();

    }





}

