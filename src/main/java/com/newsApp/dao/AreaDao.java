package com.newsApp.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AreaDao {
    String getArea(int areaNo);
}
