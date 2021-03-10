package com.lzydmc.bookstore.controller;


import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.common.Constant;
import com.lzydmc.bookstore.exception.BookStoreExceptionEnum;
import com.lzydmc.bookstore.model.pojo.User;
import com.lzydmc.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse register(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUsername())) {
            return ApiRestResponse.error(BookStoreExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return ApiRestResponse.error(BookStoreExceptionEnum.NEED_PASSWORD);
        }
        //密码长度不能少于8位
        if (user.getPassword().length() < 8) {
            return ApiRestResponse.error(BookStoreExceptionEnum.PASSWORD_TOO_SHORT);
        }
        userService.register(user.getPhone(), user.getUsername(), user.getSex(), user.getPassword() , user.getCity(), user.getArea());
        return ApiRestResponse.success();
    }

    @PostMapping("/login")
    @ResponseBody
    public ApiRestResponse login(@RequestParam("phone")String phone,
                                 @RequestParam("password")String password,
                                 HttpSession session){
        if (StringUtils.isEmpty(phone)) {
            return ApiRestResponse.error(BookStoreExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(BookStoreExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(phone,password);
        user.setPassword(null);
        session.setAttribute(Constant.BOOKSTORE_USER,user);
        return ApiRestResponse.success(user);
    }


    @PostMapping("/info/update")
    @ResponseBody
    public ApiRestResponse updateUserInfo(
    		@RequestBody User user){
        userService.updateInformation(user);
        return ApiRestResponse.success();
    }

    @PostMapping("/logout")
    @ResponseBody
    public ApiRestResponse logout(HttpSession session){
        session.removeAttribute(Constant.BOOKSTORE_USER);
        return ApiRestResponse.success();
    }
    
    
    @PostMapping("/info/detail")
    @ResponseBody
    public ApiRestResponse detail(String phone){
        User user = userService.detail(phone);
        return ApiRestResponse.success(user);
    }

}
