package com.newsApp.controller;

import com.newsApp.common.JsonData;
import com.newsApp.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "地区相关接口")
@Controller
public class AreaController {
    @Autowired
    AreaService areaService;

    @ApiOperation(value = "获取地区列表接口")
    @RequestMapping(value = {"/areaList"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getNews(){
        return areaService.getAllAreas();
    }
}
