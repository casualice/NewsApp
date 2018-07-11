package com.newsApp.service;

import com.newsApp.common.JsonData;
import com.newsApp.dto.LabelAndAreaNo;

public interface NewsService {
    JsonData getNews(LabelAndAreaNo labelAndAreaNo);

    JsonData share(int newsNo);

    JsonData like(int newsNo,int userNo);

    JsonData getOne(int NewsNo);
}
