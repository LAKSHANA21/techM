package com.javapractices.app;

import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;

public class HashSetExample {
    public static void main(String[] args) {
    	HashSet<String> name = new HashSet<>();
    	name.add("Amritha");
    	name.add("Lakshu");
    	name.add("Jaswin");
    	name.add("Deepak");
    	System.out.println(name); 
    	ArrayList<String> arr = new ArrayList<String>(name);
    	for(int i=0;i<arr.size();i++) {
    		System.out.println(arr.get(i));
    	}                                                   
        }
    }


