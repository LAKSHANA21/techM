package com.javafundamentalAssignment6.app;

import java.util.*;

class Person {
    private String firstName;
    private String lastName;
    /**
     * 
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * 
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * 
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class DisplayName{
    public static void main(String[] args) {
        PriorityQueue<Person> person = new PriorityQueue<>(
            Comparator.comparing(Person::getFirstName)
        );

        person.add(new Person("Priscilla", "Wagner"));
        person.add(new Person("Tom", "Parker"));
        person.add(new Person("Elvis", "Presley"));

        System.out.println("People sorted by first name:");
        while (!person.isEmpty()) {
            System.out.println(person.poll());
        }
    }
}

