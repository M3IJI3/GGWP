package com.example.ggwp.models.user;

public class SubscriptionModel {
    public SubscriptionModel() {
    }

    private Double basicPrice;

    public SubscriptionModel(Double freePrice, Double basicPrice, Double premiumPrice) {
        this.basicPrice = basicPrice;
        this.premiumPrice = premiumPrice;
        this.freePrice = freePrice;
    }

    public Double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Double getPremiumPrice() {
        return premiumPrice;
    }

    public void setPremiumPrice(Double premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    public Double getFreePrice() {
        return freePrice;
    }

    public void setFreePrice(Double freePrice) {
        this.freePrice = freePrice;
    }

    private Double premiumPrice;
    private Double freePrice;
}


