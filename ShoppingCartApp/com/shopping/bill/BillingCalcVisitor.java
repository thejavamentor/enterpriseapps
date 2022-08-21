package com.shopping.bill;

import com.shopping.model.DiscountModel;

import java.util.Map;

public class BillingCalcVisitor implements  Visitor{
    @Override
    public int visit(RegularCustomer customer) {
        calculateDiscount(customer);
        return customer.getDiscountedPrice();
    }


    @Override
    public int visit(PremiumCustomer customer) {
        calculateDiscount(customer);
        return customer.getDiscountedPrice();
    }


    private void calculateDiscount(CustomerTypeIntf customer) {
        int price = customer.getPrice();
        int discount = 0;
        Map<String, DiscountModel> map = customer.getDiscountMap();
        for(Map.Entry<String,DiscountModel> entrySet : map.entrySet()){
            String key = entrySet.getKey();
            DiscountModel discountModel = entrySet.getValue();
            if(price > discountModel.getMaxAmount()){
                discount = discount + discountModel.getDefaultDiscPrice();
            } else {
                int diff = price - discountModel.getMinAmount();
                discount = discount + (diff * discountModel.getDiscuntpercent())/100;
                break;
            }
        }
        customer.setDiscountedPrice(price-discount);
    }
}
