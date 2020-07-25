package com.tavisca.app;


import com.tavisca.app.service.BeverageFact;




public class BeverageApp {

   
    public static void main(String[] args) {

        BeverageFact factory = new BeverageFact();


        String orderList = " Chai ,-milk, -water,  Coffee, Mojito";

        double price = factory.getOrder(orderList);

        System.out.println("Total cost is "+ price);
       
    }


}
