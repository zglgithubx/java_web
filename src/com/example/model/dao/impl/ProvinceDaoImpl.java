package com.example.model.dao.impl;

import com.example.model.dao.ProvinceDao;
import com.example.model.domain.Province;
import com.example.model.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    @Override
    public List<Province> findAllProvince() {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select*from province";
        List<Province> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
