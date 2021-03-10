package com.lzydmc.bookstore.controller;

import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.common.Constant;
import com.lzydmc.bookstore.model.pojo.Banner;
import com.lzydmc.bookstore.model.pojo.Book;
import com.lzydmc.bookstore.service.BannerService;
import com.lzydmc.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BannerController {

    @Autowired
    BannerService bannerService;

    //显示首页大图
    @PostMapping("/banner")
    @ResponseBody
    public ApiRestResponse banner(){
        return ApiRestResponse.success(bannerService.showbanner());
    }

}
