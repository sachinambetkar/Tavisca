package com.tavisca.app.modeldata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BevarageData {
	
    public static Map<String, List<String>> getBeverages() {

        Map<String, List<String>> b_Map = new HashMap<>();
        b_Map.put("coffee", Arrays.asList("milk", "sugar", "water"));
        b_Map.put("chai", Arrays.asList("milk", "sugar", "water"));
        b_Map.put("banana_smoothy", Arrays.asList("milk", "sugar", "water"));
        b_Map.put("strawberry_shake", Arrays.asList("milk", "sugar", "water"));
        b_Map.put("mojito", Arrays.asList("sugar", "water", "soda", "mint"));
        return b_Map;
    }

    public static Map<String, Double> getBevRates() {

        Map<String, Double> item = new HashMap<>();

        item.put("coffee", 5.0d + getRates().get("milk")
                + getRates().get("water") + getRates().get("sugar"));

        item.put("chai", 4.0d + +getRates().get("milk")
                + getRates().get("water") + getRates().get("sugar"));

        item.put("banana_smoothy", 6.0d + getRates().get("milk")
                + getRates().get("water") + getRates().get("sugar"));

        item.put("strawberry_shake", 7.0d + getRates().get("milk")
                + getRates().get("water") + getRates().get("sugar"));

        item.put("mojito", 7.5d + getRates().get("soda")
                + getRates().get("water") + getRates().get("sugar")
                + getRates().get("mint"));


        return item;
    }

    public static Map<String, Double> getRates() {

        Map<String, Double> rates = new HashMap<>();
        rates.put("milk", 1.0d);
        rates.put("sugar", 0.5d);
        rates.put("soda", 0.5d);
        rates.put("mint", 0.5d);
        rates.put("water", 0.5d);

        return rates;
    }


}

