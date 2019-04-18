package com.zhonghaollc.zhonghaosite.page.component;

public class Component {

    private String id;
    private boolean exist;

    public Component(){
        this.id = "";
        this.exist = false;
    }

    public Component(String id, boolean exist) {
        this.id = id;
        this.exist = exist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
