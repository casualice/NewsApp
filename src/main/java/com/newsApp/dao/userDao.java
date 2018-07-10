package com.newsApp.dao;

import com.newsApp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userDao {
    void addUser(@Param("user") User user);

    User getUserById(int id);
}
