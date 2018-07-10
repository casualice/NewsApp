package com.newsApp.service;

import com.newsApp.common.JsonData;

public interface NewsService {
    JsonData getNews(int areaNo,int labelNo);

    JsonData share(int newsNo);

    JsonData like(int newsNo,int userNo);

    JsonData getOne(int NewsNo);
}
