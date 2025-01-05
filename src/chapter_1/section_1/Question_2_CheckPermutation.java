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

        boolean result = checkPermutation(str1, str2);
        System.out
                .println(result ? "The strings are permutations of each other." : "The strings are NOT permutations.");
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] asciiCounts = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            asciiCounts[str1.charAt(i)]++;
            asciiCounts[str2.charAt(i)]--;
        }

        for (int i = 0; i < 128; i++) {
            if (asciiCounts[i] != 0)
                return false;
        }

        return true;
    }
}