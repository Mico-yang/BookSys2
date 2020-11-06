package com.kgc.service.impl;

import com.kgc.dao.bookInfoDao;
import com.kgc.dao.bookTypeDao;
import com.kgc.dao.impl.bookInfoDaoImpl;
import com.kgc.dao.impl.bookTypeDaoImpl;
import com.kgc.entity.bookInfo;
import com.kgc.entity.bookType;
import com.kgc.service.BookService;
import com.kgc.utils.PageBean;

import java.util.List;

public class BookServiceImpl implements BookService {
    private bookInfoDao bookInfoDao = new bookInfoDaoImpl();
    private bookTypeDao bookTypeDao = new bookTypeDaoImpl();

    @Override
    public List<bookInfo> findAll() {
        return bookInfoDao.findAll();
    }

    @Override
    public void deleteBook(String id) {
        bookInfoDao.delete(id);
    }

    @Override
    public List<bookType> findAllType() {
        return bookTypeDao.findAll();
    }

    @Override
    public void insertBook(bookInfo book) {
        bookInfoDao.insert(book);
    }

    @Override
    public bookInfo findOne(String id) {
        return bookInfoDao.findById(id);
    }

    @Override
    public void updateBook(bookInfo book) {
        bookInfoDao.update(book);
    }

    @Override
    public PageBean findAllPage(PageBean pb) {
        List<bookInfo> list = bookInfoDao.findPageAll(pb.getCurrPage(), pb.getPageSize());
        pb.setList(list);
        return pb;
    }
}
