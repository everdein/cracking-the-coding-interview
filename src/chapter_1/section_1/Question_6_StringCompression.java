package chapter_1.section_1;

// Problem 1.6: String Compression
// Prompt:
// Implement a method to perform basic string compression using the counts of repeated characters. 
// For example, the string "aabcccccaaa" would become "a2b1c5a3". If the compressed string would not 
// become smaller than the original string, your method should return the original string. You can 
// assume the string has only uppercase and lowercase letters (a-z).

public class Question_6_StringCompression {

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa")); // a2b1c5a3
        System.out.println(compressString("aabbcc")); // a2b2c2
        System.out.println(compressString("abc")); // a1b1c1
        System.out.println(compressString("aaa")); // a3
        System.out.println(compressString("aa")); // a2
        System.out.println(compressString("a")); // a1
        System.out.println(compressString("")); // ""
    }

    // TODO: Implement a method utilizing StringBuilder to compress the string
    public static String compressString(String str) {
        int firstPointer = 0;
        int secondPointer = 0;
        String compressedString = "";

        // If the string is empty or has only one character, return the string
        if (str.length() == 0) {
            return str;
        }

        // If the string has only one character, return the string
        if (str.length() == 1) {
            return str;
        }

        while (secondPointer < str.length()) {
            // If the characters at the first and second pointers are the same, increment
            // the second pointer
            if (str.charAt(firstPointer) == str.charAt(secondPointer)) {
                secondPointer++;
            }
            // If the characters at the first and second pointers are different, add the
            // character at the first pointer
            else if (str.charAt(firstPointer) != str.charAt(secondPointer)) {
                compressedString = compressedString + str.charAt(firstPointer) + (secondPointer - firstPointer);
                firstPointer = secondPointer;
            }

            // If the second pointer reaches the end of the string, add the character at the
            // first pointer and the count of the character
            if (secondPointer == str.length()) {
                compressedString = compressedString + str.charAt(firstPointer) + (secondPointer - firstPointer);
            }
        }

        // Return the compressed string if it is shorter than the original string
        return compressedString.length() < str.length() ? compressedString : str;
    }
}
