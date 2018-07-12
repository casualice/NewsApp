package com.newsApp.controller;

import com.newsApp.common.JsonData;
import com.newsApp.entity.Area;
import com.newsApp.entity.Label;
import com.newsApp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "用户相关接口")
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户信息接口(包括用户选择的标签与地区信息)")
    @RequestMapping(value = {"/userMessage"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getUserMessage(){
        return userService.getUserMessage();
    }

    @ApiOperation(value = "修改地区接口")
    @RequestMapping(value = {"/changeArea"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData changeArea(@RequestParam(value = "areas[]",required = true)List<Integer> areas) throws Exception {
        return userService.changeArea(areas);
    }

    @ApiOperation(value = "修改标签接口")
    @RequestMapping(value = {"/changeLabel"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData changeLabel(@RequestParam(value = "labels[]",required = true)List<Integer> labels) throws Exception {
        return userService.changeLabel(labels);
    }
}
