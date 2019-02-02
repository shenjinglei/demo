package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name,Integer age){
        jdbcTemplate.update("insert into user(name,age) values (?,?)", name, age);
    }

    @Override
    public void deleteByName(String name){
        jdbcTemplate.update("delete from user where name = ?",name);
    }

    @Override
    public Integer getAllUsers(){
        return jdbcTemplate.queryForObject("select count(1) from User", Integer.class);
    }

    @Override
    public void deleteAllUsers(){
        jdbcTemplate.update("delete from user");
    }
}
