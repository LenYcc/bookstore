package com.lzydmc.bookstore.service.impl;

import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.model.dao.BookImgMapper;
import com.lzydmc.bookstore.model.dao.BookMapper;
import com.lzydmc.bookstore.model.dao.CommentMapper;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.BookImg;
import com.lzydmc.bookstore.service.BookImgService;
import com.lzydmc.bookstore.service.BookService;
import com.lzydmc.bookstore.service.BooksrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BooksrcServiceImpl implements BooksrcService {

    @Autowired
    BookService bookService;
    @Autowired
    BooksrcService booksrcService;
    @Autowired
    BookImgService bookImgService;

    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookImgMapper bookImgMapper;
    @Autowired
    CommentMapper commentMapper;

    @Override
    public void addbook(Book book, BookImg bookImg) {
        Integer count = bookService.insert(book);
        bookImg.setBid(book.getId().longValue());
        bookImgService.insert(bookImg);
    }

    @Override
    public void update(Book book, BookImg bookImg) {
        bookService.update(book);
        bookImg.setBid(book.getId().longValue());
        bookImgService.update(bookImg);
    }

    @Override
    public Map bookDetail(Integer bid) {
        Map boosrc = new HashMap();
        boosrc.put("book",bookMapper.selectByPrimaryKey(bid));
        boosrc.put("bookimg",bookImgMapper.selectByBookKey(bid));
        boosrc.put("comment",commentMapper.selectByBookId(bid));
        return boosrc;
    }
}
