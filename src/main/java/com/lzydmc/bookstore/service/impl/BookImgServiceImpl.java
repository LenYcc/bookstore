package com.lzydmc.bookstore.service.impl;

import com.lzydmc.bookstore.model.dao.BookImgMapper;
import com.lzydmc.bookstore.model.pojo.BookImg;
import com.lzydmc.bookstore.service.BookImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImgServiceImpl implements BookImgService {
    @Autowired
    BookImgMapper bookImgMapper;

    @Override
    public void insert(BookImg bookImg) {
        bookImgMapper.insertSelective(bookImg);
    }

    @Override
    public void update(BookImg bookImg) {
        bookImgMapper.updateByPrimaryKeySelective(bookImg);
    }
}
