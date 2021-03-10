package com.lzydmc.bookstore.service.impl;

import com.lzydmc.bookstore.model.dao.BookMapper;
import com.lzydmc.bookstore.model.dao.OrderMapper;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.Order;
import com.lzydmc.bookstore.model.response.ResOrders;
import com.lzydmc.bookstore.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Order> showorder() {
        List<Order> orders = orderMapper.selectAll();
        return orders;
    }

    @Override
    public List<Order> searchbyoid(String oid) {
        Order order = orderMapper.selectByOid(oid);
        List<Order> orders = new ArrayList();
        orders.add(order);
        return orders;
    }

    @Override
    public List<ResOrders> searchbyuserid(String userid) {
        List<ResOrders> resOrders = new ArrayList<>();
        List<Order> orders = orderMapper.selectByUserid(userid);
        for (Order order:orders){     	
            ResOrders tempResOrders = new ResOrders();
            Book book = bookMapper.selectByPrimaryKey(order.getBid());
            BeanUtils.copyProperties(order,tempResOrders);
            BeanUtils.copyProperties(book,tempResOrders);
            System.out.println(tempResOrders.toString());
            resOrders.add(tempResOrders);
        }
        System.out.println(resOrders.toString());
        return resOrders;
    }

    @Override
    public List<ResOrders> searchbyuseridrecent(String userid) {
    	System.out.println("333333");
        List<ResOrders> resOrders = new ArrayList<>();
        List<Order> orders = orderMapper.selectByUseridrecent(userid);
        System.out.println("3333333");
        if(orders!=null) {
        for (Order order:orders){
            ResOrders tempResOrders = new ResOrders();
            Book book = bookMapper.selectByPrimaryKey(order.getBid());
            BeanUtils.copyProperties(order,tempResOrders);
            BeanUtils.copyProperties(book,tempResOrders);
            resOrders.add(tempResOrders);
        }
        }
        return resOrders;
    }

    @Override
    public List<Order> searchbyuserid2(String userid) {
        List<Order> orders = orderMapper.selectByUserid(userid);
        return orders;
    }

    @Override
    public void purchase(String uid, Integer bid) {
        Order order = new Order();
        order.setUserid(uid);
        order.setBid(bid);
        Book book = bookMapper.selectByPrimaryKey(bid);
        order.setGoodprice(book.getPrice().longValue());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String oid = format.format(date) + uid;
        order.setOid(oid);
        orderMapper.insertSelective(order);
    }
}

