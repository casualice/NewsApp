package com.newsApp.dao;

import com.newsApp.entity.LabelInclude;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelIncludeDao {
    LabelInclude getByNewsNo(int newsNo);
    List<LabelInclude> getByLabelNo(int labelNo);
    List<LabelInclude> getAll();
    void delete(int newsNo);
    void update(@Param("newsNo") int newsNo, @Param("labelNo")int labelNo);
}
