package com.newsApp.service;

import com.newsApp.common.JsonData;

public interface AreaService {
    JsonData addArea(String AreaName);

    JsonData deleteArea(String AreaName);

    JsonData getAllAreas();
}
