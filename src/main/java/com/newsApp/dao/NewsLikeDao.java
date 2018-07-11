package com.newsApp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NewsLikeDao {

    void setLike(@Param("userNo") int userNo, @Param("newsNo") int newsNo);

    int likeCount(int newsNo);
}
