package chapter_1.section_1;

import java.util.Scanner;

// Problem 1.1: Is Unique
// Given two strings, write a method to decide if one is a permutation of the other.

public class Question_2_CheckPermutation {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string:");
        String str1 = scanner.nextLine();
        System.out.println("Enter second string:");
        String str2 = scanner.nextLine();
        scanner.close();
        System.out.println(checkPermutation(str1, str2));
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        if (str1.length() == 0 || str2.length() == 0)
            return false;

        int[] ascii_str1 = new int[128];
        int[] ascii_str2 = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            ascii_str1[str1.charAt(i)]++;
            ascii_str2[str2.charAt(i)]++;
        }

        for (int i = 0; i < 128; i++) {
            // System.out.println("The ASCII value of " + (char) i + " = " + i + " " +
            // ascii_str1[i]);
            if (ascii_str1[i] != ascii_str2[i])
                return false;
        }
        return true;
    }
}