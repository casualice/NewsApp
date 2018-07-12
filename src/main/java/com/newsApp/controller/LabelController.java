package com.newsApp.controller;

import com.newsApp.common.JsonData;
import com.newsApp.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "标签相关接口")
@Controller
public class LabelController {

    @Autowired
    LabelService labelService;

    @ApiOperation(value = "标签列表接口")
    @RequestMapping(value = {"/labelList"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getNews(){
        return labelService.getAllLabels();
    }
}
