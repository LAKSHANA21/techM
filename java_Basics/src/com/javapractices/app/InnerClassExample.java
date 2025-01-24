package com.javapractices.app;
class OuterClass {
	
	int a = 30;
	int b = 90;
	
	public void printadd() {
		System.out.println(a+b);
		
	}
	
	class InnerClass{
		
		public void printsub() {
		System.out.println(b-a);
		}
	}
}
	
public class InnerClassExample {
	
	public static void main(String[] args) {
		
		OuterClass outer = new OuterClass();
		outer.printadd();
		 
		OuterClass.InnerClass inner = outer. new InnerClass();
		inner.printsub();

	}

}
