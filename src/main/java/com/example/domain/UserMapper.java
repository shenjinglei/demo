package com.example.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "UserMapper")
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Select("INSERT INTO USER(NAME,AGE) VALUES(#{name}, #{age})")
    Integer insert(@Param("name") String name, @Param("age") Integer age);
}
