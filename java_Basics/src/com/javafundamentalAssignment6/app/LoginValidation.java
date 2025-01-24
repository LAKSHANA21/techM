package com.javafundamentalAssignment6.app;

import java.util.*;

class User {
    private String fullName;
    private String username;
    private String password;

    public User(String fullName, String username, String password) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}

public class LoginValidation {

    public static void main(String[] args) {
        HashMap<String, User> users = new HashMap<>();
        users.put("icrane", new User("Ichabod Crane", "icrane", "Qwerty123"));
        users.put("bbones", new User("Brom Bones", "bbones", "Pass456!"));
        users.put("epokeman", new User("Emboar Pokeman", "epokeman", "Password123"));
        users.put("rpokemon", new User("Rayquazza Pokeman", "rpokemon", "Drow456"));
        users.put("cdude", new User("Cool Dude", "cdude", "Dh456!32"));

        Scanner input = new Scanner(System.in);

        System.out.print("Login: ");
        String login = input.nextLine().trim();

        if (users.containsKey(login)) {
            User user = users.get(login);

            int attempts = 0;
            while (attempts < 3) {
                System.out.print("Password: ");
                String password = input.nextLine();

                if (user.getPassword().equals(password)) {
                    System.out.println("Login Successful!!");
                    System.out.println("Welcome " + user.getFullName() + "!!");
                    return;
                } else {
                    attempts++;
                    if (attempts < 3) {
                        System.out.println("Incorrect password. Try again.");
                    }
                }
            }
            System.out.println("Login failed. Too many incorrect attempts.");
        } else {
            System.out.println("Username not found.");
        }
        input.close();
    }
}


