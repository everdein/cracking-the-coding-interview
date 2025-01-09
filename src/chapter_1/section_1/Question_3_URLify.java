package chapter_1.section_1;

public class Question_3_URLify {
    public static void main(String[] args) {
        char[] input = "Mr John Smith    ".toCharArray();
        int trueLength = 13;

        if (urlify(input, trueLength)) {
            System.out.println("Result: " + new String(input));
        } else {
            System.out.println("Invalid input or true length.");
        }
    }

    public static boolean urlify(char[] input, int trueLength) {
        if (input == null || trueLength > input.length) {
            return false;
        }

        int spaceCount = 0;

        // Count spaces in the true length
        for (int i = 0; i < trueLength; i++) {
            if (input[i] == ' ') {
                spaceCount++;
            }
        }

        // Check if the array has enough space for replacements
        if (trueLength + spaceCount * 2 > input.length) {
            return false;
        }

        int index = trueLength + spaceCount * 2;

        // Process the string backward
        for (int i = trueLength - 1; i >= 0; i--) {
            if (input[i] != ' ') {
                input[index - 1] = input[i];
                index--;
            } else {
                input[index - 1] = '0';
                input[index - 2] = '2';
                input[index - 3] = '%';
                index -= 3;
            }
        }

        return true;
    }
}
