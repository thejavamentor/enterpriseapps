package com.shopping.bill;

import com.shopping.model.DiscountModel;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RegularCustomer implements CustomerTypeIntf {

    int price;
    String customerName;
    String serial;
    int discountedPrice;
    Map<String, DiscountModel> discountMap = new LinkedHashMap<>();

    public RegularCustomer(int price, String customerTypeName, String serial){
        this.price= price;
        this.serial=serial;
        this.customerName =customerTypeName;
        initDiscount();
    }

    private void initDiscount(){
        Map<String, DiscountModel> map = new LinkedHashMap<>();
        map.put("range1", new DiscountModel(0,5000,0, 0));
        map.put("range2", new DiscountModel(5000,10000,10, 500));
        map.put("range4", new DiscountModel(10000,Integer.MAX_VALUE,20, 0));
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
