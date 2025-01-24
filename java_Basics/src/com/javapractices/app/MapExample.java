package com.javapractices.app;
import java.util.*;
public class MapExample {
	public static void main(String[] args) {
		
	Map<Integer, String> data = new HashMap<Integer, String>();
	System.out.println(data.size());//returns the index of the last element
	
	data.put(32,"Lakshu");
	data.put(04,"Amritha");
	System.out.println(data);
	
	System.out.println(data.keySet());
	System.out.println(data.values());
	
	}

}
