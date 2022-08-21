package com.shopping.client;

import com.shopping.bill.BillingCalcVisitor;
import com.shopping.bill.PremiumCustomer;
import com.shopping.bill.RegularCustomer;
import com.shopping.bill.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ClientBillingCounterApp {
    public static void main(String[] args) {
        //streamExmple();
        ProductListStream();
        //CustomerDemo();
    }

    private static void streamExmple() {
        System.out.println("Iterating over stream collection");
        Stream.iterate(1, element->element+1)
                .filter(element->element%2==0)
                .limit(5)
                .forEach(System.out::println);
    }
    private static void ProductListStream(){

            List<Product> productsList = new ArrayList<Product>();
            //Adding Products
            productsList.add(new Product(1,"HP Laptop",25000f));
            productsList.add(new Product(2,"Dell Laptop",30000f));
            productsList.add(new Product(3,"Lenevo Laptop",28000f));
            productsList.add(new Product(4,"Sony Laptop",28000f));
            productsList.add(new Product(5,"Apple Laptop",90000f));
            // This is more compact approach for filtering data
            productsList.stream()
                    .filter(product -> product.price == 30000)
                    .forEach(product -> System.out.println(product.name));

            productsList.stream().forEach(product -> System.out.println(product.id));

    }

    private static void CustomerDemo() {
        PremiumCustomer primiumCustormers[] = {
                new PremiumCustomer(4000,"Mukesh","1000001"),
                new PremiumCustomer(8000,"Suresh","1000002"),
                new PremiumCustomer(12000,"Sharddha","1000003"),
                new PremiumCustomer(20000,"Nitin","1000004")
        };

        RegularCustomer regularCustormers[] = {
                new RegularCustomer(5000,"John","1000005"),
                new RegularCustomer(10000,"Ritesh","1000006"),
                new RegularCustomer(15000,"Sujata","1000007")
        };

        System.out.println("Premium customer discounted billings are ");
        for (PremiumCustomer customer:primiumCustormers ) {
            Visitor visitor = new BillingCalcVisitor();
            int discountedPrice = visitor.visit(customer);
            System.out.println(" customer " + customer.getCustomerName() + " got discount of "+
                    (customer.getPrice() - customer.getDiscountedPrice()) + " and final price is "
                    + customer.getDiscountedPrice());


        }

        System.out.println("Regular customer discounted billings are ");
        for (RegularCustomer customer:regularCustormers ) {
            Visitor visitor = new BillingCalcVisitor();
            int discountedPrice = visitor.visit(customer);
            System.out.println(" customer " + customer.getCustomerName() + " got discount of "+
                    (customer.getPrice() - customer.getDiscountedPrice()) + " and final price is "
                    + customer.getDiscountedPrice());


        }
    }
    static class Product{
        int id;
        String name;
        float price;
        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}
