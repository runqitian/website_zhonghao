package com.zhonghaollc.zhonghaosite.entity.index;

public class Chart {
    private String title;
    private String text;
    private String imgPath;
    private String imgDeclare;

    public Chart(){
    }

    public Chart(String title, String text, String imgPath, String imgDeclare) {
        this.title = title;
        this.text = text;
        this.imgPath = imgPath;
        this.imgDeclare = imgDeclare;
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

    public String getImgDeclare() {
        return imgDeclare;
    }

    public void setImgDeclare(String imgDeclare) {
        this.imgDeclare = imgDeclare;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", imgDeclare='" + imgDeclare + '\'' +
                '}';
    }
}
