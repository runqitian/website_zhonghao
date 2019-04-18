package com.zhonghaollc.zhonghaosite.mapper;

import com.zhonghaollc.zhonghaosite.entity.HomeBannerSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeFeaturesSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeServicesSectionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeMapper {

    List<HomeBannerSectionEntity> selectAllHomeBannerSectionEntity();

    List<HomeFeaturesSectionEntity> selectAllHomeFeaturesSectionEntity();

    List<HomeServicesSectionEntity> selectAllHomeServicesSectionEntity();

}
