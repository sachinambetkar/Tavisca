package com.tavisca.app.service;


import java.util.*;
import java.util.stream.Collectors;

import com.tavisca.app.exception.BevarageException;
import com.tavisca.app.modeldata.BevarageData;




public class BeverageFact {

    Map<String, List<String>> bMap = BevarageData.getBeverages();

    Map<String, Double> itemR = BevarageData.getBevRates();

    Map<String, Double> ingredientR = BevarageData.getRates();

    
    public double getOrder(String items) {
        double cost = 0.0d;
        List<String> list = getItemsFromOrder(items.trim());
      
       /* 
        Iterator<String> i = list.iterator();
        
        while(i.hasNext()) {
        	
            List<String> itemWithIngredients = getIngredientFromItem(i.next());
            checkIfValidOrder(i.next());
            cost = cost + calculateInvoice(itemWithIngredients);
        	
        }
       */
        
       
        for (String item : list) {
            List<String> itemWithIngredients = getIngredientFromItem(item);
     
            cost = cost + getTotal(itemWithIngredients);
        } 
        
        return cost;
    }
 
    

    private Double getTotal(List<String> itemWithIngredients) {
        Double itemValue = itemR.get(itemWithIngredients.get(0));
        Double ingredientsValue = 0.0d;
        if (itemWithIngredients.size() > 1)
            for (int i = 1; i < itemWithIngredients.size(); i++) {
                ingredientsValue = ingredientsValue + ingredientR.get(itemWithIngredients.get(i));
            }
        return itemValue - ingredientsValue;
    }


    private List<String> getItemsFromOrder(String order1) {
        return Arrays.stream(order1.split("(?!,\\s*-),")).map(String::trim).map(String::toLowerCase).collect(Collectors.toList());
    }

    private List<String> getIngredientFromItem(String item) {
        return Arrays.stream(item.split(",")).map(s -> s.replace("-", "")).map(String::trim).collect(Collectors.toList());
    }

}
