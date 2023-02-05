package com.example.model.service;

import com.example.model.domain.FirstCase;
import com.example.model.domain.PageBean;
import com.example.model.domain.User;
import java.util.List;
import java.util.Map;


public interface FirstCaseService {

    List<FirstCase> findALl();
    User login(User user);
    void add(FirstCase firstCase);
    void delete(String id);
    FirstCase findOne(String id);
    void update(FirstCase firstCase);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<FirstCase> pageQuery(String currentPage, String rows, Map<String, String[]> condition);
    

}
