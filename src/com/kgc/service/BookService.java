package com.kgc.service;

import com.kgc.entity.bookInfo;
import com.kgc.entity.bookType;
import com.kgc.utils.PageBean;

import java.util.List;

public interface BookService {
    List<bookInfo> findAll();

    void deleteBook(String id);

    List<bookType> findAllType();

    void insertBook(bookInfo book);

    bookInfo findOne(String id);

    void updateBook(bookInfo book);

    PageBean findAllPage(PageBean pb);
}
