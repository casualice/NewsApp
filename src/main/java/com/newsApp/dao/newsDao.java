package com.newsApp.dao;

import com.newsApp.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface newsDao {

    List<News> getNewsByNo(@Param("LabelNo") int LabelNo,@Param("AreaNo") int AreaNo);

    void addNews(@Param("news") News news);

    void updateNews(News news);

    News getNewsById(int id);

    void deleteById(int id);

}
