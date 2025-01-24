package com.javapractices.app;
interface Lambda{
	public void print(int a, int b);
}
public class LambdaExpressionsExample {
	public static void main(String[] args) {
	Lambda obj = (int a, int b)->{
		System.out.println(a+b);
		System.out.println(b-a);
		System.out.println(a*b);
	};
	obj.print(3,5);
	}

}

