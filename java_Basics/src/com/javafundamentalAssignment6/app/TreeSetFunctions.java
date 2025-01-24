package com.javafundamentalAssignment6.app;
import java.util.*;

public class TreeSetFunctions {
	/**
	 * 
	 * @param words
	 */
    public static void displayAllWords(TreeSet<String> words) {
        for (String word : words) {
            System.out.println(word);
        }
    }
    /**
     * 
     * @param words
     */
    public static void displayCapitalisedPluras(TreeSet<String> words) {
        for (String word : words) {
            if (word.endsWith("s")) {
                System.out.println(word.toUpperCase());
            }
        }
    }

    public static void displayReverse(TreeSet<String> words) {
        List<String> list = new ArrayList<>(words);
        Collections.reverse(list);
        for (String word : list) {
            System.out.println(word);
        }
    }
    /**
     * 
     * @param words
     */
    public static void removePlurals(TreeSet<String> words) {
        words.removeIf(word -> word.endsWith("s"));
        displayAllWords(words);
    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> datas = new TreeSet<String>();

        System.out.println("Enter words to add in the set:");
        while (true) {
            String word = sc.nextLine().trim();
            if (word.equalsIgnoreCase("done")) {
                break;
            }
            datas.add(word);
        }

        while (true) {
            System.out.println("\n1. Display all words");
            System.out.println("2. Display with Capitalised plurals");
            System.out.println("3. Display in reverse order");
            System.out.println("4. Display with plural words removed");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice >= 1 && choice <= 5) {
                switch (choice) {
                    case 1:
                        displayAllWords(datas);
                        break;

                    case 2:
                        displayCapitalisedPluras(datas);
                        break;

                    case 3:
                        displayReverse(datas);
                        break;

                    case 4:
                        removePlurals(datas);
                        break;

                    case 5 :
                        sc.close();
                        return; 
                        
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
