package com.zhonghaollc.zhonghaosite.service;

import com.zhonghaollc.zhonghaosite.entity.HomeBannerSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeChartSection;
import com.zhonghaollc.zhonghaosite.entity.HomeFeaturesSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeServicesSectionEntity;
import com.zhonghaollc.zhonghaosite.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    HomeMapper mapper;

    public List<HomeBannerSectionEntity> getAllHomeBannerSectionEntities(){
        return mapper.selectAllHomeBannerSectionEntity();
    }

    public List<HomeFeaturesSectionEntity> getAllHomeFeaturesSectionEntities(){
        return mapper.selectAllHomeFeaturesSectionEntity();
    }

    public HomeChartSection getHomeChartSection(){
        HomeChartSection homeChartSection = new HomeChartSection("title", "text", "./hello.jpg");
        return homeChartSection;
    }

    public List<HomeServicesSectionEntity> getAllHomeServicesSectionEntities(){
        return mapper.selectAllHomeServicesSectionEntity();
    }

}
