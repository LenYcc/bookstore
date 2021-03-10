package com.lzydmc.bookstore.admincontroller;


import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.common.Constant;
import com.lzydmc.bookstore.model.pojo.Order;
import com.lzydmc.bookstore.model.pojo.User;
import com.lzydmc.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


//用户管理模块

@Controller
@RequestMapping("/usermanage")
public class UsermanageController {
    @Autowired
    UserService userService;

    //显示所有用户信息
    @PostMapping("/users")
    @ResponseBody
    public ApiRestResponse list(){
        List<User> users = userService.showusers();
        return ApiRestResponse.success(users);
    }

    //搜索用户
    @PostMapping("/searchuser")
    @ResponseBody
    public ApiRestResponse search(String phone) {
        User user = userService.searchbyphone(phone);
        List<User> users = new ArrayList();
        users.add(user);
        return ApiRestResponse.success(users);
    }



//    @PostMapping("/add")
//    @ResponseBody
//    public ApiRestResponse add(){
//        return ApiRestResponse.success();
//    }
//
//
//    @PostMapping("/del")
//    @ResponseBody
//    public ApiRestResponse del(Integer id){
//        return ApiRestResponse.success();
//    }
//
//
//    @PostMapping("/update")
//    @ResponseBody
//    public ApiRestResponse update(){
//        return ApiRestResponse.success();
//    }
}
