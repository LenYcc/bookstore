package com.lzydmc.bookstore.service;

import com.lzydmc.bookstore.model.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User getUser(Integer id);
    public void register(String phone, String username, String sex, String password ,String city, String area );

    User login(String phone, String password);

    void updateInformation(User user);

    List<User> showusers();

    User searchbyphone(String phone);

    boolean checkAdminRole(User user);

    User detail(String phone);

}
