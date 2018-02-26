package com.example.demo.book.controller;

import com.example.demo.book.JPA.BookJPA;
import com.example.demo.book.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 墨殇
 * @description:
 * @Date : 2018/2/26.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookJPA bookJPA;

    /**
     * 查询书籍列表
     * @return
     */
    @RequestMapping(value = "/list")
    public List<BookBean> list(){
        return bookJPA.findAll();
    }
}