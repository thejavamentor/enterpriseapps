package com.shopping.bill;

import com.shopping.model.DiscountModel;

import java.util.Map;

public interface CustomerTypeIntf {
    public void accept(Visitor visitor);
    public int getPrice();
    public void setDiscountedPrice(int value);
    public int getDiscountedPrice();
    public Map<String, DiscountModel> getDiscountMap();
}
