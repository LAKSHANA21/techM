package com.javaAssessment3.app;

import java.io.*;
import java.util.*;

class Mobile{
	private int productId;
	private String name;
	private String modelName;
	private int memory;
	private int price;
	private String colour;
	/**
	 * 
	 * @return
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * 
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId=productId;
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * 
	 * @return
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName=modelName;
	}
	/**
	 * 
	 * @return
	 */
	public int getmemory() {
		return memory;
	}
	/**
	 * 
	 * @param memory
	 */
	public void setmemory(int memory) {
		this.memory=memory;
	}
	/**
	 * 
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price=price
				;
	}
	/**
	 * 
	 * @return
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {
		this.colour=colour;
	}
	/**
	 * 
	 * @param productId
	 * @param name
	 * @param modelName
	 * @param memory
	 * @param price
	 * @param colour
	 */
	Mobile(int productId, String name, String modelName, int memory, int price, String colour){
		this.productId=productId;
		this.name=name;
		this.modelName=modelName;
		this.memory=memory;
		this.price=price;
		this.colour=colour;
	}
}

class Management{
	/**
	 * 
	 * @param filePath
	 * @param minRange
	 * @param maxRange
	 * @return
	 */
	public Map<Integer, Integer> filterByPrice(String filePath, int minRange, int maxRange){
		Map<Integer, Integer> mobiles = new TreeMap<>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			while(true) {
				try {
					Mobile mobile = (Mobile) ois.readObject();
                    if (mobile.getPrice() >= minRange && mobile.getPrice() <= maxRange) {
                        mobiles.put(mobile.getProductId(), mobile.getPrice());
                    }
				}catch(EOFException e) {
					break;
				}
			}
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("Error "+e.getMessage());
		}
		return mobiles;
	}
}
public class MobileManagementSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the minimum price");
		int minRange = input.nextInt();
		System.out.println("Enetr the maximum price");
		int maxRange = input.nextInt();
		
		 Management management = new Management();
	        Map<Integer, Integer> detail = management.filterByPrice("mobiles.txt", minRange, maxRange);

	        if (detail.isEmpty()) {
	            System.out.println("No mobiles found for the given range.");
	        } else {
	            System.out.println("Filtered Mobiles (Product ID -> Price):");
	            detail.forEach((productId, price) -> System.out.println(productId + " -> " + price));
	        }

	        input.close();
	}
}
