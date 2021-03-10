package com.lzydmc.bookstore.controller;


import com.lzydmc.bookstore.common.ApiRestResponse;
import com.lzydmc.bookstore.model.pojo.Comment;
import com.lzydmc.bookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    //添加评价
    @PostMapping("/comment")
    @ResponseBody
    public ApiRestResponse comment(@RequestBody Comment comment){
    	//订单号 手机号 书籍id
        commentService.insertContent(comment.getOid(),comment.getUserid(),comment.getContent());
        return ApiRestResponse.success();
    }
}
