package com.zhonghaollc.zhonghaosite.entity.about;

import java.util.Arrays;

public class Feature {

    private String[] titles;
    private String[] texts;

    public Feature() {
    }

    public Feature(String[] titles, String[] texts) {
        this.titles = titles;
        this.texts = texts;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String[] getTexts() {
        return texts;
    }

    public void setTexts(String[] texts) {
        this.texts = texts;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "titles=" + Arrays.toString(titles) +
                ", texts=" + Arrays.toString(texts) +
                '}';
    }
}
