package com.javafundamentalAssignment6.app;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class LinkedHashMapPractice {
    public static void main(String[] args) {
        LinkedHashMap<String, String> vehicleTypeMap = new LinkedHashMap<>();
        vehicleTypeMap.put("car", "sedan");
        vehicleTypeMap.put("truck", "pickup");
        vehicleTypeMap.put("motorcycle", "sportbike");
        vehicleTypeMap.put("van", "minivan");
        vehicleTypeMap.put("suv", "crossover");
        
        String motorcycleCategory = vehicleTypeMap.get("motorcycle");
        System.out.println("Category of motorcycle: " + motorcycleCategory);

        vehicleTypeMap.remove("van");
        System.out.println("After removing 'van': " + vehicleTypeMap);

        boolean containsSUV = vehicleTypeMap.containsKey("suv");
        boolean containsPickupCategory = vehicleTypeMap.containsValue("pickup");
        System.out.println("Contains 'suv': " + containsSUV);
        System.out.println("Contains category 'pickup': " + containsPickupCategory);

        boolean isEmpty = vehicleTypeMap.isEmpty();
        int size = vehicleTypeMap.size();
        System.out.println("Is vehicleTypeMap empty: " + isEmpty);
        System.out.println("Number of key-value mappings: " + size);

        System.out.println("Entries in vehicleTypeMap:");
        for (Map.Entry<String, String> entry : vehicleTypeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        Set<String> vehicleTypes = vehicleTypeMap.keySet();
        Collection<String> categories = vehicleTypeMap.values();
        System.out.println("Vehicle types: " + vehicleTypes);
        System.out.println("Categories: " + categories);
    }
}

