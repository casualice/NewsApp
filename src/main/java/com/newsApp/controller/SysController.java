package com.newsApp.controller;

import com.newsApp.dao.newsDao;
import com.newsApp.dto.LabelAndAreaNo;
import com.newsApp.entity.News;
import com.newsApp.entity.NewsParam;
import com.newsApp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SysController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/404")
    public String notFound(){
        return "404";
    }

    @RequestMapping("/form")
    public String form(){
        return "form";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/log")
    public String log(){
        return "log";
    }

    @RequestMapping("/table")
    public String table(Model model){
        LabelAndAreaNo labelAndAreaNo = new LabelAndAreaNo(0,0);
        List<NewsParam> newsParams = newsService.getNewsParam(labelAndAreaNo);
        model.addAttribute("newsParams",newsParams);
        return "table";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping(value = {"/updatePage"},method = RequestMethod.GET)
    public String updatePage(Model model,int newsNo){
        NewsParam newsParam = newsService.getOneNews(newsNo);
        model.addAttribute("newsParam",newsParam);
        return "updatePage";
    }

    @RequestMapping("/delete")
    public void delete(int newsNo){
        newsService.deleteNews(newsNo);
    }
}
