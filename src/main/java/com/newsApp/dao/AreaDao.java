package com.newsApp.dao;

import com.newsApp.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {
    String getArea(int areaNo);

    List<Area> getAllAreas();

    void addArea(String areaName);

    void deleteArea(int areaNo);

    Area getByName(String areaName);
}
