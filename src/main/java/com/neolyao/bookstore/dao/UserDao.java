package com.neolyao.bookstore.dao;

import com.neolyao.bookstore.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
     User findByUserName(@Param("username") String username);
     void addUser(User user);
}
