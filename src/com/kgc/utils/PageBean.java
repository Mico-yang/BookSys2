package com.kgc.utils;

import java.util.List;

//封装分页数据
public class PageBean {
    private int pageSize = 3;
    private int totalPage;
    private int currPage;
    private int totalRows;
    //用于封装当前页面的数据
    private List<?> list;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    //第二步
    //对要输出的页面数进行判断
    public void setCurrPage(int currPage) {
        if(currPage < 1){
            this.currPage = 1;
        }else if (currPage > totalPage){
            this.currPage = totalPage;
        }else{
            this.currPage = currPage;
        }
    }

    public int getTotalRows() {
        return totalRows;
    }

    //第一步
    //设置总行数，根据总行数计算出总的页面数
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        if(totalRows % pageSize == 0){
            this.totalPage = totalRows / pageSize;
        }else{
            this.totalPage = totalRows / pageSize + 1;
        }
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
