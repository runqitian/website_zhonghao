package com.zhonghaollc.zhonghaosite.entity;

public class HomeBannerSectionEntity {
    private String subTitle;
    private String mainTitle;
    private String text;
    private String imgPath;

    public HomeBannerSectionEntity() {
    }

    public HomeBannerSectionEntity(String subTitle, String mainTitle, String text, String imgPath) {
        this.subTitle = subTitle;
        this.mainTitle = mainTitle;
        this.text = text;
        this.imgPath = imgPath;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getText() {
        return text;
    }

    public String getImgPath() {
        return imgPath;
    }

    @Override
    public String toString() {
        return "HomeBannerSectionEntity{" +
                "subTitle='" + subTitle + '\'' +
                ", mainTitle='" + mainTitle + '\'' +
                ", text='" + text + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
