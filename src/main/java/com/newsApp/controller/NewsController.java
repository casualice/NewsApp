package com.newsApp.controller;

import com.newsApp.common.JsonData;
import com.newsApp.dto.LabelAndAreaNo;
import com.newsApp.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "新闻相关接口")
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @ApiOperation(value = "新闻列表接口(包括新闻获赞数)")
    @RequestMapping(value = {"/newsList"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getNews(LabelAndAreaNo labelAndAreaNo){
        return newsService.getNews(labelAndAreaNo);
    }

    @ApiOperation(value = "分享与跳转接口，返回新闻详情路径")
    @RequestMapping(value = {"/share"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData shareNews(int newsNo){
        return newsService.share(newsNo);
    }

    @ApiOperation(value = "点赞接口")
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
