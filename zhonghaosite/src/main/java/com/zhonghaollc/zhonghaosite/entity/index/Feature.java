package com.zhonghaollc.zhonghaosite.entity.index;

public class Feature {

    private String title;
    private String text;
    private String imgPath;

    public Feature(){

    }

    public Feature(String title, String text, String imgPath) {
        this.title = title;
        this.text = text;
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "Feature{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
