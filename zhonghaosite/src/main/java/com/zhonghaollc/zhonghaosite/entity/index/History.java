package com.zhonghaollc.zhonghaosite.entity.index;

public class History {
    private String title;
    private String text;

    public History(){}

    public History(String title, String text) {
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
        return "History{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
