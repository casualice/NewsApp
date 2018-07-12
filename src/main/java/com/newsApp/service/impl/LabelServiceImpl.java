package com.newsApp.service.impl;

import com.newsApp.common.JsonData;
import com.newsApp.dao.LabelDao;
import com.newsApp.entity.Area;
import com.newsApp.entity.Label;
import com.newsApp.service.LabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("LabelService")
public class LabelServiceImpl implements LabelService {
    @Resource
    LabelDao labelDao;

    @Override
    public JsonData addLabel(String labelName) {
        try {
            if(labelDao.getByName(labelName)!=null)
                return JsonData.fail("标签已存在！");
            labelDao.addLabel(labelName);
            return JsonData.success("插入成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("添加失败！");
    }

    @Override
    public JsonData deleteLabel(String labelName) {
        try {
            Label label = labelDao.getByName(labelName);
            if(label==null)
                return JsonData.fail("标签不存在！");
            int LabelNo = label.getLabelNo();
            labelDao.deleteLabel(LabelNo);
            return JsonData.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("删除失败！");
    }

    @Override
    public JsonData getAllLabels() {
        try {
            List<Label> labels = labelDao.getAllLabels();
            return JsonData.success(labels,"获取标签列表成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("获取标签列表失败！");
    }
}
