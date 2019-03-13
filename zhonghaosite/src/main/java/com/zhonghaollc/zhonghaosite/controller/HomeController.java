package com.zhonghaollc.zhonghaosite.controller;


import com.zhonghaollc.zhonghaosite.entity.HomeBannerSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeChartSection;
import com.zhonghaollc.zhonghaosite.entity.HomeFeaturesSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeServicesSectionEntity;
import com.zhonghaollc.zhonghaosite.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/bannersectioninit")
    public List<HomeBannerSectionEntity> bannerSectionInit(){
        return homeService.getAllHomeBannerSectionEntities();
    }

    @GetMapping("/featuressectioninit")
    public List<HomeFeaturesSectionEntity> featuresSectionInit(){
        return homeService.getAllHomeFeaturesSectionEntities();
    }

    @GetMapping("/chartsectioninit")
    public HomeChartSection homeChartSectionInit(){
        return homeService.getHomeChartSection();
    }

    @GetMapping("/servicessectioninit")
    public List<HomeServicesSectionEntity> homeServicesSectionInit(){
        return homeService.getAllHomeServicesSectionEntities();
    }


}
