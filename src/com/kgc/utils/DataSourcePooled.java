package com.kgc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class DataSourcePooled {
    private  static  DataSource dataSource;
    private  DataSourcePooled(){}
    static {
        dataSource=new ComboPooledDataSource();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }

    public static void main(String[] args) {
        System.out.println(DataSourcePooled.getDataSource());
    }
}
