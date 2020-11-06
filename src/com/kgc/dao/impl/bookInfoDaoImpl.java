package com.kgc.dao.impl;

import com.kgc.dao.bookInfoDao;
import com.kgc.entity.bookInfo;
import com.kgc.utils.DataSourcePooled;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class bookInfoDaoImpl implements bookInfoDao {
    //数据库连接池的对象
    private QueryRunner runner = new QueryRunner(DataSourcePooled.getDataSource());


    @Override
    public void insert(bookInfo bookInfo) {
        String sql = "insert into book_info values (null,?,?,?,?,?,?)";
        Object[] params = new Object[]{bookInfo.getBook_name(),
                bookInfo.getBook_author(),bookInfo.getBook_price(),
                bookInfo.getBook_pub(),bookInfo.getBook_state(),
                bookInfo.getType_id()};
        try {
            runner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(bookInfo bookInfo) {
        String sql = "update book_info set book_name = ? " +
                ", book_author = ? , book_price = ? , book_pub = ? , book_state = ?" +
                ", type_id = ? where book_id = ?";
        Object[] params = new Object[]{bookInfo.getBook_name(),
                bookInfo.getBook_author(),bookInfo.getBook_price(),
                bookInfo.getBook_pub(),bookInfo.getBook_state(),
                bookInfo.getType_id(),bookInfo.getBook_id()};
        try {
            runner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Serializable id) {
        String sql = "delete from book_info where book_id = ?";
        try {
            runner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<bookInfo> findAll() {
        String sql = "select * from book_info";
        try {
            return runner.query(sql,new BeanListHandler<bookInfo>(bookInfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public bookInfo findById(Serializable id) {
        String sql = "select * from book_info where book_id = ?";
        try {
            return runner.query(sql,new BeanHandler<bookInfo>(bookInfo.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        bookInfoDao bookInfoDao = new bookInfoDaoImpl();
        bookInfo bookInfo1 = new bookInfo(5,"Java","李四",100,"汉阳出版社",0,2);
        bookInfoDao.update(bookInfo1);

    }

    @Override
    public List<bookInfo> findPageAll(int currentPage, int pageSize) {
        String sql = "select * from book_info limit ? ,?";
        try {
            return runner.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),(currentPage-1)*pageSize,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
