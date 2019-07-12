package com.zhonghaollc.zhonghaosite.entity.contact;

public class Office {

    private String name;
    private String address;
    private String phone;
    private String email;
    private String imgPath;

    public Office() {
    }

    public Office(String name, String address, String phone, String email, String imgPath) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Office{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
