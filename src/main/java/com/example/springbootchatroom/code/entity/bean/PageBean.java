package com.example.springbootchatroom.code.entity.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {

    private Integer totalCount;

    private Integer currentPage;

    private Integer totalPage;

    private Integer size;

    private List<T> data;

    public static Integer getTotalPage(Integer size, Integer totalCount){
        if (totalCount/size == 0){
            return 1;
        } else if (totalCount/size != 0 && totalCount % size == 0){
            return totalCount/size;
        }else {
            return totalCount/size + 1;
        }
    }
}
