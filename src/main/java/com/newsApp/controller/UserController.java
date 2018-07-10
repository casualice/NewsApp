package com.newsApp.controller;

import com.newsApp.common.JsonData;
import com.newsApp.entity.Area;
import com.newsApp.entity.Label;
import com.newsApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/userMessage"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getUserMessage(){
        return userService.getUserMessage();
    }

    @RequestMapping(value = {"/changeArea"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData changeArea(List<Area> areas){
        return userService.changeArea(areas);
    }

    @RequestMapping(value = {"/changeLabel"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData changeLabel(List<Label> labels){
        return userService.changeLabel(labels);
    }
}
