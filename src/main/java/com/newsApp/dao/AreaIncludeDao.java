package com.newsApp.dao;

import com.newsApp.entity.AreaInclude;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaIncludeDao {
    AreaInclude getByNewsNo(int newsNo);

    List<AreaInclude> getByAreaNo(int areaNo);
}
