package com.example.model.dao;

import com.example.model.domain.FirstCase;

import java.util.List;
import java.util.Map;

public interface FirstCaseDao {
    List<FirstCase> findAll();
    void add(FirstCase firstCase);
    void delete(String id);
    FirstCase findOne(String id);
    void update(FirstCase firstCase);
    int findTotalCount(Map<String, String[]> condition);
    List<FirstCase> pageQuery(int start, int rows, Map<String, String[]> condition);
}
