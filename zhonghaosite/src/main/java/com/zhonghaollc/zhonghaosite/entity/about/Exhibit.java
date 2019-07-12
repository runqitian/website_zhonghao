package com.zhonghaollc.zhonghaosite.entity.about;

import javafx.util.Pair;

import java.util.Arrays;

public class Exhibit {

    class Figure {
        private String title1;
        private String title2;
        private String text;
        private String imgPath;

        Figure(){
        }

        public Figure(String title1, String title2, String text, String imgPath) {
            this.title1 = title1;
            this.title2 = title2;
            this.text = text;
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
            return "Figure{" +
                    "title1='" + title1 + '\'' +
                    ", title2='" + title2 + '\'' +
                    ", text='" + text + '\'' +
                    ", imgPath='" + imgPath + '\'' +
                    '}';
        }
    }

    private Pair<String, String>[] upperbox;
    private Pair<String, Figure[]> tabs;

    public Exhibit() {
    }

    public Exhibit(Pair<String, String>[] upperbox, Pair<String, Figure[]> tabs) {
        this.upperbox = upperbox;
        this.tabs = tabs;
    }

    public Pair<String, String>[] getUpperbox() {
        return upperbox;
    }

    public void setUpperbox(Pair<String, String>[] upperbox) {
        this.upperbox = upperbox;
    }

    public Pair<String, Figure[]> getTabs() {
        return tabs;
    }

    public void setTabs(Pair<String, Figure[]> tabs) {
        this.tabs = tabs;
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "upperbox=" + Arrays.toString(upperbox) +
                ", tabs=" + tabs +
                '}';
    }
}
