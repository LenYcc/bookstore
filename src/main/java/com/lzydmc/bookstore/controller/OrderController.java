package com.lzydmc.bookstore.controller;


import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @PostMapping("/purchase")
    public ApiRestResponse purchase(String uid,Integer bid){
        orderService.purchase(uid,bid);
        return ApiRestResponse.success();
    }
}
