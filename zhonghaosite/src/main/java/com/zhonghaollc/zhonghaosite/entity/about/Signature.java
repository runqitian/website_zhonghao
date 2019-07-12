package com.zhonghaollc.zhonghaosite.entity.about;

public class Signature {

    private String title;
    private  String text;
    private String job;
    private String person;
    private String imgPath;

    public Signature() {
    }

    public Signature(String title, String text, String job, String person, String imgPath) {
        this.title = title;
        this.text = text;
        this.job = job;
        this.person = person;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Signature{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", job='" + job + '\'' +
                ", person='" + person + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
