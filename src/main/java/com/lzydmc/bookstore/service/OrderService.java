package com.lzydmc.bookstore.service;

import com.lzydmc.bookstore.model.pojo.Order;
import com.lzydmc.bookstore.model.response.ResOrders;

import java.util.List;

public interface OrderService {
    List<Order> showorder();

    List<Order> searchbyoid(String oid);

    List<ResOrders> searchbyuserid(String userid);

    List<ResOrders> searchbyuseridrecent(String phone);

    List<Order> searchbyuserid2(String userid);

    void purchase(String uid, Integer bid);
}
