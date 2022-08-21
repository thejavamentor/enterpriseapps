package com.shopping.bill;

public interface Visitor {
    public int visit(RegularCustomer customer);
    public int visit(PremiumCustomer customer);
}
