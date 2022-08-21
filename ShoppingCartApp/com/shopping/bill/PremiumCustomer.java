package com.shopping.bill;

import com.shopping.model.DiscountModel;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PremiumCustomer implements CustomerTypeIntf {

    int price;
    String customerName;
    String serial;
    int discountedPrice;
    Map<String, DiscountModel> discountMap = new LinkedHashMap<>();


    public PremiumCustomer(int price, String customerTypeName, String serial){
        this.price= price;
        this.serial=serial;
        this.customerName =customerTypeName;
        initDiscount();
    }

    private void initDiscount(){
        Map<String, DiscountModel> map = new LinkedHashMap<>();
        map.put("range1", new DiscountModel(0,4000,10, 400));
        map.put("range2", new DiscountModel(4000,8000,15, 600));
        map.put("range3", new DiscountModel(8000,12000,20, 800));
        map.put("range4", new DiscountModel(12000,Integer.MAX_VALUE,30, 0));
        discountMap = Collections.unmodifiableMap(map);
    }

    @Override
    public void accept(Visitor visitor) {
           visitor.visit(this);
    }

    public int getPrice() {
        return price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getSerial() {
        return serial;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Map<String, DiscountModel> getDiscountMap() {
        return discountMap;
    }

}
