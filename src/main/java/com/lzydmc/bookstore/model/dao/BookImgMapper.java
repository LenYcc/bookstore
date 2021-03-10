package com.lzydmc.bookstore.model.dao;

import com.lzydmc.bookstore.model.pojo.BookImg;
import org.springframework.stereotype.Repository;

@Repository
public interface BookImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookImg record);

    int insertSelective(BookImg record);

    BookImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookImg record);

    int updateByPrimaryKey(BookImg record);

    BookImg selectByBookKey(Integer bid);
}