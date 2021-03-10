package com.lzydmc.bookstore.service;

import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.pojo.BookImg;
import com.lzydmc.bookstore.model.request.Booksrc;

import java.util.Map;

public interface BooksrcService {

    void addbook(Book book, BookImg bookImg);

    void update(Book book, BookImg bookImg);

    Map bookDetail(Integer bid);
}
