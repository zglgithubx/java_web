package com.example.model.service;

import com.example.model.domain.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAllProvince();
    String findJson();
}
