package com.newsApp.dao;

import com.newsApp.entity.labelChoose;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelChooseDao {
    void set(@Param("userNo")int userNo,@Param("labelNo")int labelNo);

    void delete(int userNo);

    List<labelChoose> getLabelChooseByUserId(int userNo);
}
