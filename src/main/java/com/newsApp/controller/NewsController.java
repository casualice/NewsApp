package com.newsApp.controller;

import com.newsApp.common.JsonData;
import com.newsApp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/newsList"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getNews(int labelNo,int areaNo){
        return newsService.getNews(areaNo,labelNo);
    }

    @RequestMapping(value = {"/share"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData shareNews(int newsNo){
        return newsService.share(newsNo);
    }

    @RequestMapping(value = {"/like"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData likeNews(int newsNo){
        return newsService.like(newsNo,1);
    }

    @RequestMapping(value = {"/getNews"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getOneNews(int NewsNo){
        return newsService.getOne(NewsNo);
    }
}
