package com.neolyao.bookstore.service;

import com.neolyao.bookstore.pojo.Book;
import com.neolyao.bookstore.pojo.Category;

import java.util.List;

public interface BookService {
    public List<Book> getBooksByCid(String cid);
    public List<Category> getCategory();
    public Book findByBid(String bid);
}
