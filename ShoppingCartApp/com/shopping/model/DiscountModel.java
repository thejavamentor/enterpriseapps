package com.shopping.model;

public class DiscountModel {

    private int minAmount;
    private int maxAmount;
    private int discuntpercent;
    public int defaultDiscPrice;

    public DiscountModel(int minAmount, int maxAmount, int discuntPercent) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.discuntpercent = discuntPercent;
    }

    public DiscountModel(int minAmount, int maxAmount, int discuntPercent, int defaultDescPrice) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.discuntpercent = discuntPercent;
        this.defaultDiscPrice = defaultDescPrice;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getDiscuntpercent() {
        return discuntpercent;
    }

    public int getDefaultDiscPrice() {
        return defaultDiscPrice;
    }

    public void setDefaultDiscPrice(int defaultDiscPrice) {
        this.defaultDiscPrice = defaultDiscPrice;
    }
}
