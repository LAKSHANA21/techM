package com.javapractices.app;
import java.io.*;
public class FileInputStreamExample {
	public static void main(String[] args) {
	try {
		FileInputStream input = new FileInputStream("UsersDetails.txt");
		System.out.println("Data in the file: ");
		int i =input.read();
		while(i!=-1) {
			System.out.print((char)i);	
			i=input.read();
		}
		input.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
