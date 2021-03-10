package com.lzydmc.bookstore.service;

import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.Order;
import com.lzydmc.bookstore.model.request.Booklist;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> hotlist(Integer salesvolume);
    List<Book> newlist();
    List<Book> listall();
    Integer insert(Book book);
    void del(Integer id);

    void update(Book book);

    List<Book> searchByName(String name);

    List<Book> searchRandom();

    List<Book> booklist(Integer pagenum, Integer pagesize);
}
