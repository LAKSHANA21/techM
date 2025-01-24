package com.javapractices.app;
class OuterClasses {
	
	int a = 30;
	static int b = 90;
	
	public void printadd() {
		System.out.println(a+b);
	}
	
	static class InnerClasses{
		public void printsub(OuterClasses o) {
		System.out.println(b-o.a);
		}
	}
}
	  
public class StaticNestedInnerClass {
	
	public static void main(String[] args) {
		
		OuterClasses outer = new OuterClasses();
		outer.printadd();
		
		OuterClasses.InnerClasses inner = new  OuterClasses.InnerClasses();
		inner.printsub(outer);

	}

}
