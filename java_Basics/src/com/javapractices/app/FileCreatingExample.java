package com.javapractices.app;

import java.io.File;
import java.io.IOException;

public class FileCreatingExample {
	public static void main(String[] args) {
	try{
		File file = new File("example.txt");
		if(file.createNewFile()) {
		System.out.println(file.getName());
	}else {
		System.out.println("Already exsits");
	}
	}catch(IOException e) {
		System.out.println("Error");
		e.printStackTrace();
	}
	}
}
