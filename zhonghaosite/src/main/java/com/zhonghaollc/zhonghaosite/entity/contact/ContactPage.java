package com.zhonghaollc.zhonghaosite.entity.contact;

import java.util.Arrays;

public class ContactPage {

    private Office[] offices;

    public ContactPage() {
    }

    public ContactPage(Office[] offices) {
        this.offices = offices;
    }

    public Office[] getOffices() {
        return offices;
    }

    public void setOffices(Office[] offices) {
        this.offices = offices;
    }

    @Override
    public String toString() {
        return "ContactPage{" +
                "offices=" + Arrays.toString(offices) +
                '}';
    }
}
