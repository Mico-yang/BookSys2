package com.kgc.dao;

import com.kgc.entity.bookInfo;

import java.util.List;

public interface bookInfoDao extends Dao<bookInfo> {
    public List<bookInfo> findPageAll(int currentPage,int pageSize);
}
