package com.newsApp.dao;

import com.newsApp.entity.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabelDao {
    String getLabel(int labelNo);

    List<Label> getAllLabels();

    void addLabel(String labelName);

    void deleteLabel(int labelNo);

    Label getByName(String labelName);
}
