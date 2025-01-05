package chapter_1.section_1;

// Problem 1.1: Is Unique
// Implement an algorithm to determine if a string has all unique
// characters. What if you cannot use additional data structures?

public class Question_1_IsUnique {

    public static void main(String[] args) throws Exception {
        String str = "aabcde"; // true
        // String str = "abcde"; // false
        System.out.println(isUnique(str));
    }

    public static boolean isUnique(String str) {
        for (int i = 0; i < str.length(); i++) {
            Character value = str.charAt(i);
            System.out.println(value);
            for (int j = 0; j < str.length(); j++)
                if (j != i)
                    if (value == str.charAt(j))
                        return false;
        }
        return true;
    }
}