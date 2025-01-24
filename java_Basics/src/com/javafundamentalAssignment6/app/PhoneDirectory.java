package com.javafundamentalAssignment6.app;

import java.util.HashMap;

public class PhoneDirectory {
    private HashMap<String, String> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public String findNumber(String name) {
        return directory.getOrDefault(name, "Name not found in the directory.");
    }

    public void specifyPhoneNumber(String name, String phoneNumber) {
        directory.put(name, phoneNumber); 
        System.out.println("Directory updated: " + name + " -> " + phoneNumber);
    }

    public void displayDirectory() {
        if (directory.isEmpty()) {
            System.out.println("The directory is empty.");
        } else {
            directory.forEach((name, number) -> System.out.println(name + ": " + number));
        }
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.specifyPhoneNumber("Alice", "123-456-7890");
        phoneDirectory.specifyPhoneNumber("Bob", "987-654-3210");
        
        System.out.println(phoneDirectory.findNumber("Alice"));
        System.out.println(phoneDirectory.findNumber("Charlie"));
        
        phoneDirectory.displayDirectory();
        
        phoneDirectory.specifyPhoneNumber("Alice", "111-222-3333"); 
        phoneDirectory.displayDirectory();
    }
}

