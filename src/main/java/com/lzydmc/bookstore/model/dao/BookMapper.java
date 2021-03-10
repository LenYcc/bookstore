package com.lzydmc.bookstore.model.dao;

import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectBySalesVolume(Integer salesVolume);

    List<Book> selectByNew();

    List<Book> selectAll();

    List<Book> selectByName(String name);

    List<Book> selectRandom();

    List<Book> selectByKey(String keyword, Integer pagenum, Integer pagesize);

    List<Book> selectByPage(Integer pagenum, Integer pagesize);
}