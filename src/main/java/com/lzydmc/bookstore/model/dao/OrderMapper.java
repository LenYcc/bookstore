package com.lzydmc.bookstore.model.dao;

import com.lzydmc.bookstore.model.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectAll();

    Order selectByOid(String oid);

    List<Order> selectByUserid(String userid);

    List<Order> selectByUseridrecent(String userid);
}