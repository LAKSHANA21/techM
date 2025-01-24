package com.javafundamentalAssignment4.app;

import java.util.Scanner;

class PayOutOfBoundsException extends Exception {
 public PayOutOfBoundsException(String message) {
     super(message);
 }
}

class AccountManagement {
 private static final int MAX_TRANSACTION_LIMIT = 30000;
 private static final int INITIAL_BALANCE = 80000;    
 private int currentBalance;

 public AccountManagement() {
     this.currentBalance = INITIAL_BALANCE; 
 }

 public void checkForDebit(int amount) throws PayOutOfBoundsException {
     if (amount > MAX_TRANSACTION_LIMIT) {
         throw new PayOutOfBoundsException("Transaction amount exceeds the maximum transaction limit of " + MAX_TRANSACTION_LIMIT + ".");
     }
     if (amount > currentBalance) {
         throw new PayOutOfBoundsException("Insufficient balance. Current balance is " + currentBalance + ".");
     }
 }

 public void withdrawAmount(int amount) throws PayOutOfBoundsException {
     checkForDebit(amount); 
     currentBalance -= amount; 
     System.out.println("Transaction successful! Amount withdrawn: " + amount);
     System.out.println("Remaining balance: " + currentBalance);
 }
}

public class TransactionApp {
 public static void main(String[] args) {
     AccountManagement account = new AccountManagement();
     java.util.Scanner scanner = new java.util.Scanner(System.in);

     try {
         System.out.print("Enter the amount to withdraw: ");
         int amount = scanner.nextInt();

         account.withdrawAmount(amount);
     } catch (PayOutOfBoundsException e) {
         System.err.println("Transaction Failed: " + e.getMessage());
     } catch (java.util.InputMismatchException e) {
         System.err.println("Invalid input. Please enter a valid integer amount.");
     } finally {
         scanner.close(); 
     }
 }
}

