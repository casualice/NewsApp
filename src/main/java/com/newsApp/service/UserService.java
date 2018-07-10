package com.newsApp.service;

import com.newsApp.common.JsonData;
import com.newsApp.entity.Area;
import com.newsApp.entity.Label;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public JsonData getUserMessage();

    public JsonData changeArea(List<Area> areas);

    public JsonData changeLabel(List<Label> labels);
}
