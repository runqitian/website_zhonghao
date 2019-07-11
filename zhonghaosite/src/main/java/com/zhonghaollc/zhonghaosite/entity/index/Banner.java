package com.zhonghaollc.zhonghaosite.entity.index;

public class Banner {
    private String subTitle;
    private String mainTitle;
    private String text;
    private String imgPath;

    public Banner() {
    }

    public Banner(String subTitle, String mainTitle, String text, String imgPath) {
        this.subTitle = subTitle;
        this.mainTitle = mainTitle;
        this.text = text;
        this.imgPath = imgPath;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "subTitle='" + subTitle + '\'' +
                ", mainTitle='" + mainTitle + '\'' +
                ", text='" + text + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
