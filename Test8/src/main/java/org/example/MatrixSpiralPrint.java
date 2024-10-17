package org.example;

import java.util.Scanner;

public class MatrixSpiralPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the matrix.
        System.out.println("Enter the size of the matrix (rows, columns): ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        // Create the matrix.
        int[][] matrix = new int[rows][columns];

        // Get the elements of the matrix.
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Print the matrix in spiral order.
        int row = 0;
        int column = 0;
        while (row < rows && column < columns) {
            // Print the top row.
            for (int i = column; i < columns; i++) {
                System.out.print(matrix[row][i] + " ");
            }

            // Print the right column.
            for (int i = row + 1; i < rows; i++) {
                System.out.print(matrix[i][columns - 1] + " ");
            }

            // Print the bottom row.
            for (int i = columns - 2; i >= column; i--) {
                System.out.print(matrix[rows - 1][i] + " ");
            }

            // Print the left column.
            for (int i = rows - 2; i > row; i--) {
                System.out.print(matrix[i][column] + " ");
            }

            // Move to the next row and column.
            row++;
            column++;
        }

        System.out.println();
    }
}