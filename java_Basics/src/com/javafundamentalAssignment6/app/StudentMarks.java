package com.javafundamentalAssignment6.app;
import java.util.*;
public class StudentMarks {
	/**
	 * 
	 * @param student
	 * @return
	 */
	public static Stack<String> pushOperation(HashMap<String, Integer> student){
		Stack<String> name = new Stack<>();
		for(String names : student.keySet()) {
			if(student.get(names)>75) {
				name.push(names);
			}
		}
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public static void pushOperation(Stack<String> name) {
		while(!name.isEmpty()) {
			System.out.println(name.pop());
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    HashMap<String, Integer> data = new HashMap<String, Integer>();
	    data.put("Lakshu", 90);
	    data.put("Amritha", 89);
	    data.put("Jaswin", 91);
	    data.put("Nikitha", 76);
	    data.put("Deva",30);
	    Stack<String> student = pushOperation(data);
	    pushOperation(student);
	    sc.close();
	}

}
