package com.newsApp.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsLikeDao {

    void setLike(int userNO,int newsNo);

    int likeCount(int newsNo);
}
