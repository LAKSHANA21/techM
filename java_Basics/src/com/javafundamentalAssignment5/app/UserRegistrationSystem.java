package com.javafundamentalAssignment5.app;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;


class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private LocalDate dob;
    private String gender;

    public User(String name, String email, String password, String phoneNumber, String address, LocalDate dob, String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}

class RegisteredUserException extends Exception {
    public RegisteredUserException(String message) {
        super(message);
    }
}

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

class InvalidEmailFormatException extends Exception {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}

class UserManagementSystem {
    private static final String FILE_PATH = "users.dat";

    public void registerUser(User user) throws Exception {
        List<User> users = loadUsers();

        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new RegisteredUserException("Email already registered.");
            }
        }

        if (!isValidEmail(user.getEmail())) {
            throw new InvalidEmailFormatException("Invalid email format.");
        }

        if (!isStrongPassword(user.getPassword())) {
            throw new WeakPasswordException("Password must be at least 8 characters long, with at least one digit, one uppercase, one lowercase, and one special character.");
        }

        users.add(user);
        saveUsers(users);
    }

    public void validateUser(String email, String password) throws Exception {
        List<User> users = loadUsers();

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                if (user.getPassword().equals(password)) {
                    System.out.println("Login successful! Welcome, " + user.getName());
                    return;
                } else {
                    throw new IncorrectPasswordException("Incorrect password.");
                }
            }
        }
        throw new UserNotFoundException("User not found with the provided email.");
    }

    private List<User> loadUsers() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        }
    }

    private void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean isStrongPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }
}

public class UserRegistrationSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UserManagementSystem ums = new UserManagementSystem();

        System.out.println("Welcome to the User Management System!");
        while (true) {
            System.out.println("\n1. Register User");
            System.out.println("2. Validate User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name =input.nextLine();
                        System.out.print("Email: ");
                        String email = input.nextLine();
                        System.out.print("Password: ");
                        String password = input.nextLine();
                        System.out.print("Phone Number: ");
                        String phone = input.nextLine();
                        System.out.print("Address: ");
                        String address = input.nextLine();
                        System.out.print("Date of Birth (YYYY-MM-DD): ");
                        LocalDate dob = LocalDate.parse(input.nextLine());
                        System.out.print("Gender: ");
                        String gender = input.nextLine();

                        User user = new User(name, email, password, phone, address, dob, gender);
                        ums.registerUser(user);
                        System.out.println("User registered successfully!");
                        break;

                    case 2:
                        System.out.print("Email: ");
                        email = input.nextLine();
                        System.out.print("Password: ");
                        password = input.nextLine();
                        ums.validateUser(email, password);
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

