package com.zhonghaollc.zhonghaosite.entity;

public class HomeHistorySectionEntity {
    private String title;
    private String text;

    public HomeHistorySectionEntity(){}

    public HomeHistorySectionEntity(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "HomeHistorySectionEntity{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
