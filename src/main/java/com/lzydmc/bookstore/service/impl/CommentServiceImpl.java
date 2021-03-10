package com.lzydmc.bookstore.service.impl;

import com.lzydmc.bookstore.model.dao.BookMapper;
import com.lzydmc.bookstore.model.dao.CommentMapper;
import com.lzydmc.bookstore.model.dao.OrderMapper;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.Comment;
import com.lzydmc.bookstore.model.pojo.Order;
import com.lzydmc.bookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void insertContent(String oid, String userid,String content) {
        Order order = orderMapper.selectByOid(oid);
        int bid = order.getBid();
        Book book = bookMapper.selectByPrimaryKey(bid);
        String bookname = book.getName();
        Comment comment = new Comment();
        comment.setOid(oid);
        comment.setUserid(userid);
        comment.setBid(bid);
        comment.setBname(bookname);
        comment.setContent(content);
        commentMapper.insertSelective(comment);
    }
}
