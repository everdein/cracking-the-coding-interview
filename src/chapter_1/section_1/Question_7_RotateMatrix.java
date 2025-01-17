package chapter_1.section_1;

// Problem 1.7: Rotate Matrix
// Prompt:
// Given an image represented by an 𝑛 × 𝑛
// n×n matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

// TODO: Linear algrebra

public class Question_7_RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },

                // { 1, 2, 3, 4 },
                // { 5, 6, 7, 8 },
                // { 9, 10, 11, 12 },
                // { 13, 14, 15, 16 }
        };

        rotateMatrixInPlace(matrix);

        // Print the rotated matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Output
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }

    public static void rotateMatrixInPlace(int[][] matrix) {
        int n = matrix.length;
        // 1. Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Print the transposed matrix
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println();
        // }

        // Output
        // 1 4 7
        // 2 5 8
        // 3 6 9

        // 2. Reverse each row
        for (int i = 0; i < n; i++) {
            // Reverse row i
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        // Print a new line
        // System.out.println();

        // Print the rotated matrix
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println();
        // }

        // Output
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }
}
