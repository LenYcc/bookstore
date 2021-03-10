package com.lzydmc.bookstore.controller;

import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.common.Constant;
import com.lzydmc.bookstore.model.dao.BookMapper;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.model.request.Booklist;
import com.lzydmc.bookstore.service.BookService;
import com.lzydmc.bookstore.service.BooksrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BooksrcService booksrcService;

    //首页热书
    @PostMapping("/hotlist")
    @ResponseBody
    public ApiRestResponse hotlist(){
        return ApiRestResponse.success(bookService.hotlist(Constant.BOOKSTORE_HOT_NUM));
    }

    //首页新书
    @PostMapping("/newlist")
    @ResponseBody
    public ApiRestResponse newlist(){
        return ApiRestResponse.success(bookService.newlist());
    }

    //书籍列表
    @PostMapping("/booklist")
    @ResponseBody
    public ApiRestResponse booklist(Integer pagenum,Integer pagesize){
        return ApiRestResponse.success(bookService.booklist(pagenum,pagesize));
    }


    //查找书籍
    @PostMapping("/findbook")
    @ResponseBody
    public ApiRestResponse sbooklist(String name){
    	System.out.println(name);
        return ApiRestResponse.success(bookService.searchByName(name));
    }

    //书籍详情
    @PostMapping("/detail")
    @ResponseBody
    public ApiRestResponse bookdetail(Integer bid){
        return ApiRestResponse.success(booksrcService.bookDetail(bid));
    }


    //书籍详细信息
    @PostMapping("/bookmsg")
    @ResponseBody
    public ApiRestResponse bookmsg(){
        return ApiRestResponse.success(bookService.booklist(1,3));
    }

}
