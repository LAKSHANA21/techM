package com.javafundamentalAssignment6.app;
import java.util.*;
public class TreeMapPractice {
	public static void main(String[] args) {
		TreeMap<String, Integer> studentMap = new TreeMap<String, Integer>();
		studentMap.put("Alice", 20);
		studentMap.put("Bob", 22);
		studentMap.put("Charlie", 18);
		studentMap.put("David", 25);
		studentMap.put("Eva", 21);
		
		System.out.println("After removing entry for Charlie");
		studentMap.remove("Charlie");
		
		System.out.println("Checking the entry for bob in map");
		boolean result = studentMap.containsKey("Bob");
		System.out.println(result);
		
		boolean isEmpty = studentMap.isEmpty();
	    int size = studentMap.size();
	    System.out.println("Is studentMap empty? " + isEmpty);
	    System.out.println("Size of studentMap: " + size);
	    
	    System.out.println("Entries in studentMap:");
        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Map.Entry<String, Integer> maxEntry = studentMap.lastEntry();
        System.out.println("Entry with the maximum key: " + maxEntry);

        Map.Entry<String, Integer> minEntry = studentMap.firstEntry();
        System.out.println("Entry with the minimum key: " + minEntry);

        Map.Entry<String, Integer> firstEntry = studentMap.pollFirstEntry();
        System.out.println("Polled first entry: " + firstEntry);

        Map.Entry<String, Integer> lastEntry = studentMap.pollLastEntry();
        System.out.println("Polled last entry: " + lastEntry);

        System.out.println("Final state of studentMap: " + studentMap);

	}

}
