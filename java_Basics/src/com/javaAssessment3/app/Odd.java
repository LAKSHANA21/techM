package com.javaAssessment3.app;

import java.util.*;

class OddNumber implements Runnable{
	private int n;
	/**
	 * 
	 * @return
	 */
	public int getN() {
		return n;
	}
	/**
	 * 
	 * @param n
	 */
	public void setN(int n) {
		this.n=n;
	}
	/**
	 * 
	 * @param n
	 */
	OddNumber(int n){
		this.n=n;
	}
	
	@Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread starting");
        for (int i = 1, count = 0; count < n; i += 2, count++) {
            System.out.print(i + " ");
        }
        System.out.println("\n" + Thread.currentThread().getName() + " thread finished");
}
}

class Reverse implements Runnable{
	private int n;
	/**
	 * 
	 * @return
	 */
	public int getN() {
		return n;
	}
	/**
	 * 
	 * @param n
	 */
	public void setN(int n) {
		this.n=n;
	}
	/**
	 * 
	 * @param n
	 */
	Reverse(int n){
		this.n=n;
	}
	@Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread starting");
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println("\n" + Thread.currentThread().getName() + " thread finished");
	}
}
public class Odd {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n=input.nextInt();
		
        Thread oddthread = new Thread(new OddNumber(n), "Odd Numbers");

        Thread revthread = new Thread(new Reverse(n), "Reverse");

        oddthread.start();
        revthread.start();
        
        input.close();
	}

}
