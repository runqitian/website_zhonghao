package com.zhonghaollc.zhonghaosite.entity.index;

public class Service {

    private String title;
    private String text;
    private String imgPath;
    private String href;

    public Service(){
    }

    public Service(String title, String text, String imgPath, String href) {
        this.title = title;
        this.text = text;
        this.imgPath = imgPath;
        this.href = href;
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Service{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
