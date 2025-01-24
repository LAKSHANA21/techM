package com.javapractices.app;

class OuterClassM{
	int a = 30;
	int b = 90;
	public void add() {
		System.out.println(a+b);
		class InnerClassM{
			public void sub() {
				System.out.println(b-a);
			}
		} 
		InnerClassM cal = new InnerClassM();
		cal.sub();
	}
}
public class MethodLocalInnerClass {

	public static void main(String[] args) {
		OuterClassM outer = new OuterClassM();
		outer.add();

	}

}
