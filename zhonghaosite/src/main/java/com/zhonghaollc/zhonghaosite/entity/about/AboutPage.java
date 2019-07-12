package com.zhonghaollc.zhonghaosite.entity.about;

public class AboutPage {

    private Signature signature;
    private Feature feature;
    private Exhibit exhibit;

    public AboutPage() {
    }

    public AboutPage(Signature signature, Feature feature, Exhibit exhibit) {
        this.signature = signature;
        this.feature = feature;
        this.exhibit = exhibit;
    }

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Exhibit getExhibit() {
        return exhibit;
    }

    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }

    @Override
    public String toString() {
        return "AboutPage{" +
                "signature=" + signature +
                ", feature=" + feature +
                ", exhibit=" + exhibit +
                '}';
    }
}

