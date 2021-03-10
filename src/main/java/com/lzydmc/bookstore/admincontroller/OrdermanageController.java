package com.lzydmc.bookstore.admincontroller;


import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.common.Constant;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.Order;
import com.lzydmc.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//订单管理模块

@Controller
@RequestMapping("/ordermanage")
public class OrdermanageController {

    @Autowired
    OrderService orderService;

    //默认显示所有订单
    @PostMapping("/orders")
    @ResponseBody
    public ApiRestResponse list(){
        List<Order> orders = orderService.showorder();
        return ApiRestResponse.success(orders);
    }

    //按订单号搜索订单
    @PostMapping("/searchorder")
    @ResponseBody
    public ApiRestResponse search(String oid){
        List<Order> orders = orderService.searchbyoid(oid);
        return ApiRestResponse.success(orders);
    }


    //按用户搜索订单
    @PostMapping("/searchorder2")
    @ResponseBody
    public ApiRestResponse search2(String userid){
        List<Order> orders = orderService.searchbyuserid2(userid);
        return ApiRestResponse.success(orders);
    }
}
