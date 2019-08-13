package com.neolyao.bookstore.dao;

import com.neolyao.bookstore.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    public  List<Book> getBooksByCid( @Param("cid") String cid);
    public  Book    findByBid(String bid);
}
