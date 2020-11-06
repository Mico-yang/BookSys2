package com.kgc.dao.impl;

import com.kgc.dao.bookTypeDao;
import com.kgc.entity.bookInfo;
import com.kgc.entity.bookType;
import com.kgc.utils.DataSourcePooled;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class bookTypeDaoImpl implements bookTypeDao {
    private QueryRunner runner = new QueryRunner(DataSourcePooled.getDataSource());

    @Override
    public void insert(bookType bookType) {

    }

    @Override
    public void update(bookType bookType) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public List<bookType> findAll() {
        String sql = "select * from book_type";
        try {
            return runner.query(sql,new BeanListHandler<bookType>(bookType.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public bookType findById(Serializable id) {
        String sql = "select * from book_type where type_id = ?";
        try {
            return runner.query(sql,new BeanHandler<bookType>(bookType.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        bookTypeDao bookTypeDao = new bookTypeDaoImpl();
        List<bookType> list = bookTypeDao.findAll();
        for (bookType bookType : list) {
            System.out.println(bookType);
        }
    }
}
