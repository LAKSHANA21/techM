package com.ecommerce.app;

import java.util.Scanner;

public class LoginModule {

    private static String savedUsername;
    private static String savedPassword;
    private static String savedEmail;
    private static String savedPhoneNumber;

    public static void createAccount(Scanner sc) {
        System.out.println("Enter the username: ");
        savedUsername = sc.next();

        System.out.println("Enter the password: ");
        savedPassword = sc.next();

        System.out.println("Enter the email: ");
        savedEmail = sc.next();

        System.out.println("Enter the phone number: ");
        savedPhoneNumber = sc.next();

        System.out.println("Account created successfully!\n");
    }

    public static void forgotPassword(Scanner sc) {
        System.out.println("Enter new password: ");
        savedPassword = sc.next();

        System.out.println("Password reset successfully!\n");
    }

    public static void signIn(Scanner sc) {
        System.out.println("Enter the username: ");
        String username = sc.next();

        System.out.println("Enter the password (or type 'forgot password' to reset):");
        String password = sc.next();

        if ("forgot password".equalsIgnoreCase(password)) {
            forgotPassword(sc);
        } else if (username.equals(savedUsername) && password.equals(savedPassword)) {
            System.out.println("Logged in successfully!\n");
        } else {
            System.out.println("Invalid username or password.\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create Account\n2. Sign In\n3. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount(sc);
                    break;

                case 2:
                    signIn(sc);
                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid input. Please try again.\n");
                    break;
            }
        }
        sc.close();
    }
}
