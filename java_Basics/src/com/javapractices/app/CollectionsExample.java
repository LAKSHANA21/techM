package com.javapractices.app;
import java.util.*;
public class CollectionsExample {

	public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	list.add("e");
	System.out.println(list);
	list.addAll(Arrays.asList("C", "D"));
	System.out.println(list);
    System.out.println(list.get(1));
    System.out.println(list.indexOf("c"));
    System.out.println(list.lastIndexOf("a"));
    list.set(3, "j");
    System.out.println(list);
    
    List<String> sublist = list.subList(0, 2);
    for (String s : list) System.out.print(s);
	}

}
