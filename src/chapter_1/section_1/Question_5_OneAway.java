package chapter_1.section_1;

import java.util.HashSet;

// Problem 1.5: One Away
// Prompt:
// There are three types of edits that can be performed on strings:

// 1. Insert a character
// 2. Remove a character
// 3. Replace a character

// Given two strings, write a function to check if they are one edit (or zero edits) away.

public class Question_5_OneAway {
    public static void main(String[] args) {
        // Test cases for the oneAway method
        System.out.println(oneAway("pale", "ple")); // true
        System.out.println(oneAway("pales", "pale")); // true
        System.out.println(oneAway("pale", "bale")); // true
        System.out.println(oneAway("pale", "bake")); // false
        System.out.println(oneAway("pale", "paleee")); // false
        System.out.println(oneAway("abc", "ac")); // true
    }

    /**
     * Checks if two strings are one or zero edits away (insert, remove, or
     * replace).
     * 
     * @param str1 the first string
     * @param str2 the second string
     * @return true if the strings are one edit away, false otherwise
     */
    public static boolean oneAway(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return replace(str1, str2); // Check for replacement
        } else if (str1.length() + 1 == str2.length()) {
            return insertOrRemove(str2, str1); // Check for insertion
        } else if (str1.length() - 1 == str2.length()) {
            return insertOrRemove(str1, str2); // Check for removal
        }
        return false; // Strings differ by more than one edit
    }

    /**
     * Checks if exactly one character in str1 can be replaced to match str2.
     * 
     * @param str1 the first string
     * @param str2 the second string
     * @return true if one replacement makes the strings equal, false otherwise
     */
    public static boolean replace(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 1)
                    return false; // More than one difference
            }
        }
        return true; // At most one difference
    }

    /**
     * Checks if adding or removing one character makes the strings equal.
     * Assumes 'longer' is longer by exactly one character.
     * 
     * @param longer  the longer string
     * @param shorter the shorter string
     * @return true if one insertion/removal makes the strings equal, false
     *         otherwise
     */
    public static boolean insertOrRemove(String longer, String shorter) {
        int i = 0, j = 0;
        boolean foundDifference = false;
        while (i < longer.length() && j < shorter.length()) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                if (foundDifference)
                    return false; // Second difference found
                foundDifference = true; // First difference found
                i++; // Skip one character in the longer string
            } else {
                i++;
                j++;
            }
        }
        return true; // At most one difference
    }
}
