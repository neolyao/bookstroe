package com.neolyao.bookstore.service;


import com.neolyao.bookstore.pojo.User;


public interface UserService {
    public User findByUserName(String username);
    public void addUser(User user);
}
