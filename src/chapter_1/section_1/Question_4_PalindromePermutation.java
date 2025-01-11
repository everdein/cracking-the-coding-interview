package chapter_1.section_1;

import java.util.HashSet;

// Problem 1.4: Palindrome Permutation
// Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
// The palindrome does not need to be limited to dictionary words.

public class Question_4_PalindromePermutation {
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
                "Tact Coa", // Expected: true
                "Tact boa", // Expected: false
                "", // Expected: true
                "    ", // Expected: true
                "a", // Expected: true
                "abc", // Expected: false
                "aabbccdd", // Expected: true
                "aabbccd", // Expected: true
                "AaBbCcDd", // Expected: true
        };

        // Test each case
        for (String testCase : testCases) {
            System.out
                    .println("Input: \"" + testCase + "\", Result: " +
                            arrayAndCountSolutionIsPalindromePermutation(testCase.toLowerCase()));
            // .println("Input: \"" + testCase + "\", Result: " +
            // optimizedArrayAndCountSolutionIsPalindromePermutation(testCase.toLowerCase()));
            // .println("Input: \"" + testCase + "\", Result: "
            // + hashSetSolutionIsPalindromePermutation(testCase.toLowerCase()));
        }
    }

    // Array & count solution
    public static boolean arrayAndCountSolutionIsPalindromePermutation(String str) {
        // Create an array to store the count of each character in the string
        int[] asciiCounts = new int[128];

        // Count the number of each character in the string
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') { // Ignore spaces
                asciiCounts[str.charAt(i)]++; // Increment the count of the character
            }
        }

        // Check if the string is a palindrome permutation
        int oddCount = 0;
        // Check if there is more than one odd count
        for (int i = 0; i < asciiCounts.length; i++) {
            if (asciiCounts[i] % 2 != 0) {
                oddCount++;
            }
            // If there are more than one odd count, then it is not a palindrome
            if (oddCount > 1) {
                return false; // Not a palindrome permutation
            }
        }
        return true; // Palindrome permutation
    }

    // Optimized array & count solution
    public static boolean optimizedArrayAndCountSolutionIsPalindromePermutation(String str) {
        int[] asciiCounts = new int[128];
        int oddCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                asciiCounts[c]++;
                if (asciiCounts[c] % 2 == 0) {
                    oddCount--;
                } else {
                    oddCount++;
                }
            }
        }
        return oddCount <= 1;
    }

    // Hash set solution
    public static boolean hashSetSolutionIsPalindromePermutation(String str) {
        HashSet<Character> oddChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                if (oddChars.contains(c)) {
                    oddChars.remove(c); // Toggle off if it's already odd
                } else {
                    oddChars.add(c); // Add if it's the first occurrence or toggles to odd
                }
            }
        }
        // Valid if there's at most one character with an odd count
        return oddChars.size() <= 1;
    }
}