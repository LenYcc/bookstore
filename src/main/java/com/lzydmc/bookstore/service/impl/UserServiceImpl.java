package com.lzydmc.bookstore.service.impl;

import com.lzydmc.bookstore.exception.BookStoreException;
import com.lzydmc.bookstore.exception.BookStoreExceptionEnum;
import com.lzydmc.bookstore.model.dao.UserMapper;
import com.lzydmc.bookstore.model.pojo.User;
import com.lzydmc.bookstore.service.UserService;
import com.lzydmc.bookstore.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void register(String phone, String username, String sex, String password ,String city, String area) {
        //查询是否存在
        User result = userMapper.selectByName(username);
        if (result!=null){
             throw new BookStoreException(BookStoreExceptionEnum.NAME_EXISTED);
        }

        //写入数据库
        User user = new User();
        user.setPhone(phone);
        user.setUsername(username);
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setSex(sex);
        user.setCity(city);
        user.setArea(area);
        int count = userMapper.insertSelective(user);
        if (count == 0){
            throw new BookStoreException(BookStoreExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public User login(String phone, String password){
        String MD5password = null;
        try {
            MD5password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = userMapper.selectLogin(phone,MD5password);
        if (user == null){
            throw new BookStoreException(BookStoreExceptionEnum.WRONG_PASSWORD);
        }
        return user;
    }

    @Override
    public void updateInformation(User user){
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if(updateCount != 1){
            throw new BookStoreException(BookStoreExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public List<User> showusers() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public User searchbyphone(String phone) {
        User user = userMapper.selectByPhone(phone);
        return user;
    }

    @Override
    public boolean checkAdminRole(User user) {
        //1是普通用户，2是管理员
        return user.getRole().equals(2);
    }

    @Override
    public User detail(String phone) {
        return userMapper.selectByPhone(phone);
    }

}
