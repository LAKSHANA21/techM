 package com.javapractices.app;

import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedList;

class Student{
	private int id;
	private String name;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id=id;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public Student(int id, String name) {
		this.id= id;
		this .name=name;
	}
}

public class LinkedListexample {

	public static void main(String[] args) {
	LinkedList<Student> id = new LinkedList<Student>();
	id.add(new Student(32,"Lakshu"));
	id.add(new Student(4,"Amritha"));
	id.add(new Student(23,"Jaswin"));
	id.add(new Student(39,"Nikitha"));
	id.add(new Student(9,"Deva"));

	for(int i=0;i<id.size();i++) {
		System.out.print(id.get(i).getid()+" ");
		System.out.println(id.get(i).getname());
	}
	
	Collections.sort(id, new Comparator<Student>() {
         public int compare(Student s1, Student s2) {
             return Integer.compare(s1.getid(), s2.getid());
         }
     });
	
	for(int i=0;i<id.size();i++) {
		System.out.print(id.get(i).getid()+" ");
		System.out.println(id.get(i).getname());
	}
	}
	}


