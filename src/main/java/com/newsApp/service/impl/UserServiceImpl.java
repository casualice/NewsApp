package com.newsApp.service.impl;

import com.newsApp.common.JsonData;
import com.newsApp.dao.*;
import com.newsApp.entity.*;
import com.newsApp.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    userDao userDao;

    @Resource
    AreaChooseDao areaChooseDao;

    @Resource
    LabelChooseDao labelChooseDao;

    @Resource
    AreaDao areaDao;

    @Resource
    LabelDao labelDao;

    @Override
    @Transactional
    public JsonData getUserMessage() {
        try {
            User user = userDao.getUserById(1);
            List<areaChoose> areaChooses = areaChooseDao.getAreaChooseByUserNo(1);
            Iterator iterator = areaChooses.iterator();
            List<Area> areas = new LinkedList<Area>();
            while (iterator.hasNext()){
                areaChoose areaChoose = (com.newsApp.entity.areaChoose) iterator.next();
                int areaNo = areaChoose.getAreaNo();
                String a = areaDao.getArea(areaNo);
                Area area = Area.builder().areaNo(areaNo)
                        .areaName(a).build();
                areas.add(area);
            }
            List<labelChoose> labelChooses = labelChooseDao.getLabelChooseByUserId(1);
            Iterator it = labelChooses.iterator();
            List<Label> labels = new LinkedList<Label>();
            while (it.hasNext()){
                labelChoose labelChoose = (com.newsApp.entity.labelChoose) it.next();
                int labelNo = labelChoose.getLabelNo();
                String l = labelDao.getLabel(labelNo);
                Label label = Label.builder()
                        .labelName(l).labelNo(labelNo).build();
                labels.add(label);
            }
            UserMessage userMessage = UserMessage.builder()
                    .userName(user.getUserName())
                    .userNo(user.getUserNo()).userTime(user.getUserTime())
                    .areas(areas).labels(labels)
                    .wechatId(user.getWechatId()).build();
            return JsonData.success(userMessage,"获取用户信息成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("获取用户信息失败！");
    }

    @Override
    @Transactional
    public JsonData changeArea(List<Integer> areas) throws Exception{
        try {
            areaChooseDao.deleteByUserNo(1);
            Iterator iterator = areas.iterator();
            while (iterator.hasNext()){
                int area = (int) iterator.next();
                if (areaDao.getArea(area)==null)
                    throw new Exception("地区不存在！");
                areaChooseDao.setAreaChoose(area);
            }
            return JsonData.success("修改用户地区信息成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("修改用户地区信息失败！");
    }

    @Override
    @Transactional
    public JsonData changeLabel(List<Integer> labels) throws Exception{
        try {
            labelChooseDao.delete(1);
            Iterator iterator = labels.iterator();
            while (iterator.hasNext()){
                int label = (int) iterator.next();
                if (labelDao.getLabel(label)==null) {
                    throw new Exception("标签不存在！");
                }
                labelChooseDao.set(1,label);
            }
            return JsonData.success("修改用户标签信息成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("修改用户标签信息失败！");
    }
}
