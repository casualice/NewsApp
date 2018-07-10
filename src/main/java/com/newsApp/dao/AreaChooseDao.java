package com.newsApp.dao;

import com.newsApp.entity.areaChoose;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaChooseDao{
    void setAreaChoose(int areaNo);

    List<areaChoose> getAreaChooseByUserNo(int userNo);

    void deleteByUserNo(int userNo);

}
