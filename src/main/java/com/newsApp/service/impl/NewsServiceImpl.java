package com.newsApp.service.impl;

import com.newsApp.common.JsonData;
import com.newsApp.dao.NewsLikeDao;
import com.newsApp.dao.newsDao;
import com.newsApp.dto.LabelAndAreaNo;
import com.newsApp.entity.News;
import com.newsApp.entity.NewsParam;
import com.newsApp.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service("NewsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    newsDao newsDao;

    @Resource
    NewsLikeDao newsLikeDao;

    @Override
    public JsonData getNews(LabelAndAreaNo labelAndAreaNo) {
        List<News> news = null;
        try{
            news = newsDao.getNewsByNo(labelAndAreaNo.getLabelNo(),labelAndAreaNo.getAreaNo());
            List<NewsParam> newsParams = new LinkedList<NewsParam>();
            Iterator iterator = news.iterator();
            while (iterator.hasNext()){
                News n = (News) iterator.next();
                NewsParam newsParam = NewsParam.builder().
                        newsAreaNo(n.getNewsAreaNo()).newsIntro(n.getNewsIntro()).
                        newsLabelNo(n.getNewsLabelNo()).newsNo(n.getNewsNo()).
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
            String shareMessage = newsDao.getNewsById(newsNo).getNewsUrl();
            return JsonData.success(shareMessage,"分享成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonData.fail("分享失败！");
    }

    @Override
    public JsonData like(int newsNo,int userNo) {
        try {
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
