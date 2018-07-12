package com.newsApp.dao;

import com.newsApp.entity.LabelInclude;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabelIncludeDao {
    LabelInclude getByNewsNo(int newsNo);
    List<LabelInclude> getByLabelNo(int labelNo);
}
