package com.javapractices.app;
import java.io.*;
public class FileOutputSystemExample {
	public static void main(String[] args) {
		String data = "Jaswin";
	try {
		FileOutputStream fos = new FileOutputStream("UsersDetails.txt");
		byte[] bytedata = data.getBytes();
		fos.write(bytedata);
		System.out.println("Data written successfullly");
	}catch(IOException e) {
		e.printStackTrace();
	}

	}

}
