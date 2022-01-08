package com.example.springbootchatroom.code.entity.bean;

import java.util.List;

public class PageBean<T> {
    private Integer totalPage;

    private Integer currentPage;

    private Integer size;

    private List<T> data;

    public PageBean(Integer totalPage, Integer currentPage, Integer size, List<T> data) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.size = size;
        this.data = data;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
