package com.newsApp.service.impl;

import com.newsApp.common.JsonData;
import com.newsApp.dao.AreaIncludeDao;
import com.newsApp.dao.LabelIncludeDao;
import com.newsApp.dao.NewsLikeDao;
import com.newsApp.dao.newsDao;
import com.newsApp.dto.LabelAndAreaNo;
import com.newsApp.entity.*;
import com.newsApp.service.NewsService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("NewsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    newsDao newsDao;

    @Resource
    NewsLikeDao newsLikeDao;

    @Resource
    AreaIncludeDao areaIncludeDao;

    @Resource
    LabelIncludeDao labelIncludeDao;

    @Override
    public JsonData getNews(LabelAndAreaNo labelAndAreaNo) {
        List<News> news = null;
        try{
            List<AreaInclude> areaIncludes = areaIncludeDao.getByAreaNo(labelAndAreaNo.getAreaNo());
            List<LabelInclude> labelIncludes = labelIncludeDao.getByLabelNo(labelAndAreaNo.getLabelNo());
            Set<Integer> areaNos = new HashSet<>();
            Set<Integer> labelNos = new HashSet<>();
            Iterator it1 = areaIncludes.iterator();
            while (it1.hasNext()){
                AreaInclude areaInclude = (AreaInclude) it1.next();
                int areaNo = areaInclude.getNewsNo();
                areaNos.add(areaNo);
            }
            Iterator it2 = areaIncludes.iterator();
            while (it2.hasNext()){
                LabelInclude labelInclude = (LabelInclude) it2.next();
                int labelNo = labelInclude.getNewsNo();
                labelNos.add(labelNo);
            }
            areaNos.retainAll(labelNos);
            news = newsDao.getNewsByNo(labelAndAreaNo.getLabelNo(),labelAndAreaNo.getAreaNo());
            List<NewsParam> newsParams = new LinkedList<NewsParam>();
            Iterator iterator = news.iterator();
            while (iterator.hasNext()){
                News n = (News) iterator.next();
                NewsParam newsParam = NewsParam.builder().
                        newsIntro(n.getNewsIntro()).
                        newsNo(n.getNewsNo()).
                        newsSource(n.getNewsSource()).newsTitle(n.getNewsTitle())
                        .newsUrl(n.getNewsUrl()).build();
                newsParam.setLikeNum(newsLikeDao.likeCount(n.getNewsNo()));
                newsParams.add(newsParam);
            }
            return JsonData.success(newsParams,"获取新闻成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("获取新闻失败");
    }



    @Override
    public JsonData share(int newsNo) {
        try {
            News news = newsDao.getNewsById(newsNo);
            if(news==null)
                return JsonData.fail("新闻不存在！");
            String shareMessage = news.getNewsUrl();
            return JsonData.success(shareMessage,"分享成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("分享失败！");
    }

    @Override
    public JsonData like(int newsNo,int userNo) {
        try {
            if(newsDao.getNewsById(newsNo)==null)
                return JsonData.fail("新闻不存在！");
            newsLikeDao.setLike(userNo,newsNo);
            return JsonData.success("点赞成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("点赞失败！");
    }

    @Override
    public JsonData getOne(int NewsNo) {
        try {
            News news = newsDao.getNewsById(NewsNo);
            return JsonData.success(news,"获取新闻详情成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("获取新闻详情失败！");
    }
}
