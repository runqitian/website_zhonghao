package com.zhonghaollc.zhonghaosite.entity;

public class HomeBannerSectionEntity {
    private String title1;
    private String title2;
    private String title3;
    private String imgPath;

    public HomeBannerSectionEntity() {
    }

    public HomeBannerSectionEntity(String title1, String title2, String title3, String imgPath) {
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.imgPath = imgPath;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "HomeBannerSectionEntity{" +
                "title1='" + title1 + '\'' +
                ", title2='" + title2 + '\'' +
                ", title3='" + title3 + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
