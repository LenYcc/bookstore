package com.lzydmc.bookstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.User;
import com.lzydmc.bookstore.model.response.ResOrders;
import com.lzydmc.bookstore.service.BookService;
import com.lzydmc.bookstore.service.OrderService;
import com.lzydmc.bookstore.service.UserService;

@Controller
public class InfoController {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

//    @PostMapping("/info")
//    @ResponseBody
//    public ApiRestResponse InfoController(String phone){
//    	System.out.println(phone);
//        Map result  = new HashMap();
//        System.out.println("111111");
//        List<ResOrders> recentorders = this.showrorders(phone);
//        System.out.println("1111111");
//        List<Book> gusessbooks = this.gussesulike();
//        System.out.println("11111111");
//        result.put("recentorders", recentorders);
//        result.put("gusessbooks", gusessbooks);
//        result.put("user",userService.detail(phone));
//        List<Map> a=new ArrayList();
//        a.add(result);
//        return ApiRestResponse.success(a);
//    }

    public InfoController(){

    }

    public ApiRestResponse ret(ApiRestResponse apiRestResponse){
        return apiRestResponse;
    }

    @PostMapping("/info/showorders")
    @ResponseBody  
    public ApiRestResponse showrorders(String phone){
        List<ResOrders> orders = orderService.searchbyuseridrecent(phone);
        return ApiRestResponse.success(orders);
    }

    @PostMapping("/info/gussesulike")
    @ResponseBody 
    public ApiRestResponse gussesulike(){
        List<Book> books = bookService.searchRandom();
        return ApiRestResponse.success(books);
    }

    @PostMapping("/info/orders")
    @ResponseBody
    public ApiRestResponse showorders(String phone){
        List<ResOrders> orders = orderService.searchbyuserid(phone);
        return ApiRestResponse.success(orders);
    }

    public User detail(@RequestParam("phone")String phone ){
        User user = userService.detail(phone);
        return user;
    }
}
