package com.example.model.dao.impl;

import com.example.model.dao.UserDao;
import com.example.model.domain.FirstCase;
import com.example.model.domain.User;
import com.example.model.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User login(User use) {
        try {
            String sql="select*from user where username=? and password=?";
            User user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),use.getUsername(),use.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }
}
