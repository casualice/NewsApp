package com.newsApp.service;

import com.newsApp.common.JsonData;
import com.newsApp.dto.LabelAndAreaNo;
import com.newsApp.dto.NewsUpdateDto;
import com.newsApp.entity.News;
import com.newsApp.entity.NewsParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsService {
    JsonData getNews(LabelAndAreaNo labelAndAreaNo);

    JsonData share(int newsNo);

    JsonData like(int newsNo,int userNo);

    JsonData getOne(int NewsNo);

    List<NewsParam> getNewsParam(LabelAndAreaNo labelAndAreaNo);

    NewsParam getOneNews(int id);

    void deleteNews(int newsNo);

    void updateNews(NewsUpdateDto news);

    JsonData newsDetail(int newsNo);
}
