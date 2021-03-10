package com.lzydmc.bookstore.service.impl;

import com.lzydmc.bookstore.model.dao.BookMapper;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.Order;
import com.lzydmc.bookstore.model.request.Booklist;
import com.lzydmc.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> hotlist(Integer salesvolume){
        List<Book> books =  bookMapper.selectBySalesVolume(salesvolume);
        return books;
    }
    @Override
    public List<Book> newlist(){
        List<Book> books =  bookMapper.selectByNew();
        return books;
    }

    @Override
    public List<Book> listall() {
        List<Book> books =  bookMapper.selectAll();
        return books;
    }

    @Override
    public Integer insert(Book book) {
        Integer id =  bookMapper.insertSelective(book);
        return id;
    }

    @Override
    public void del(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public List<Book> searchByName(String name) {
        return bookMapper.selectByName(name);
    }

    @Override
    public List<Book> searchRandom() {
        List<Book> books = bookMapper.selectRandom();
        for (Book book:books){
            book.setDetail(null);
            book.setStock(null);
            book.setSalesVolume(null);
            book.setStatus(null);
            book.setCreateTime(null);
            book.setUpdateTime(null);
        }
        return books;
    }

    @Override
    public List<Book> booklist(Integer pagenum, Integer pagesize) {
        List<Book> books = bookMapper.selectByPage(pagenum,pagesize);
        return books;
    }
}
