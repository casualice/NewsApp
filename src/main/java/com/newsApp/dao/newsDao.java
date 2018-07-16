package com.newsApp.dao;

import com.newsApp.dto.NewsUpdateDto;
import com.newsApp.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface newsDao {

    List<News> getAllNews();

    void addNews(@Param("news") News news);

    void updateNews(NewsUpdateDto news);

    News getNewsById(int id);

    void deleteById(int id);

}
