package com.newsApp.service.impl;

import com.newsApp.common.JsonData;
import com.newsApp.dao.AreaDao;
import com.newsApp.entity.Area;
import com.newsApp.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("AreaService")
public class AreaServiceImpl implements AreaService {
    @Resource
    AreaDao areaDao;

    @Override
    public JsonData addArea(String AreaName) {
        try {
            if(areaDao.getByName(AreaName)!=null)
                return JsonData.fail("地区已存在！");
            areaDao.addArea(AreaName);
            return JsonData.success("插入成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("添加失败！");
    }

    @Override
    public JsonData deleteArea(String AreaName) {
        try {
            Area area = areaDao.getByName(AreaName);
            if(area==null)
                return JsonData.fail("地区不存在！");
            int AreaNo = area.getAreaNo();
            areaDao.deleteArea(AreaNo);
            return JsonData.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("删除失败！");
    }

    @Override
    public JsonData getAllAreas() {
        try {
            List<Area> areas = areaDao.getAllAreas();
            return JsonData.success(areas,"获取地区列表成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("获取地区列表失败！");
    }
}
