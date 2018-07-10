package com.newsApp.dao;

import com.newsApp.entity.Label;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LabelDao {
    String getLabel(int labelNo);
}
