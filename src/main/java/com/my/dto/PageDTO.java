package com.my.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *@author Ye
 *@create 2020/5/31 13:10
 */
@Data
public class PageDTO {
    List<QuestionDTO> questionDTOS;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages;
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        pages = new ArrayList<>();//实例化一下,否则空指针异常
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

//!!!
        this.page = page;


        System.out.println("page"+page);
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }


        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }

    }
}
