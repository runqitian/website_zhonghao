package com.zhonghaollc.zhonghaosite.entity.index;

import java.util.Arrays;

public class IndexPage {

    private Banner[] banners;
    private Feature[] features;
    private History[] history;
    private Chart[] chart;
    private Service[] services;

    public IndexPage() {
    }

    public IndexPage(Banner[] banners, Feature[] features, History[] history, Chart[] chart, Service[] services) {
        this.banners = banners;
        this.features = features;
        this.history = history;
        this.chart = chart;
        this.services = services;
    }

    public Banner[] getBanners() {
        return banners;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public History[] getHistory() {
        return history;
    }

    public Chart[] getChart() {
        return chart;
    }

    public Service[] getServices() {
        return services;
    }

    public void setBanners(Banner[] banners) {
        this.banners = banners;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }

    public void setHistory(History[] history) {
        this.history = history;
    }

    public void setChart(Chart[] chart) {
        this.chart = chart;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "IndexPage{" +
                "banners=" + Arrays.toString(banners) +
                ", features=" + Arrays.toString(features) +
                ", history=" + Arrays.toString(history) +
                ", chart=" + Arrays.toString(chart) +
                ", services=" + Arrays.toString(services) +
                '}';
    }
}
