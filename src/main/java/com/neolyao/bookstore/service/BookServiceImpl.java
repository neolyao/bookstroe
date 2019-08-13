package com.neolyao.bookstore.service;

import com.neolyao.bookstore.dao.BookDao;
import com.neolyao.bookstore.dao.CategoryDao;
import com.neolyao.bookstore.pojo.Book;
import com.neolyao.bookstore.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements  BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryDao categoryDao;
    @Override
    public List<Book> getBooksByCid(String cid) {
        return bookDao.getBooksByCid(cid);
    }

    @Override
    public List<Category> getCategory() {
        return categoryDao.getCategory();
    }

    @Override
    public Book findByBid(String bid) {
        return bookDao.findByBid(bid);
    }
}
