package com.neolyao.bookstore.controller;

import com.neolyao.bookstore.pojo.Book;
import com.neolyao.bookstore.pojo.Category;
import com.neolyao.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/books/{cid}")
    public List<Book> getBooksByCid(@PathVariable("cid") String cid){
        return bookService.getBooksByCid(cid);
    }
    @GetMapping("/category")
    public List<Category> getCategory(){
        return bookService.getCategory();
    }
    @GetMapping("/book/{bid}")
    public Book getBookById(@PathVariable String bid){
        return bookService.findByBid(bid);
    }
}
