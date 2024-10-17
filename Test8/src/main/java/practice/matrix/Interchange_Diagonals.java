package practice.matrix;

import java.util.Scanner;

public class Interchange_Diagonals {
    public static void main(String[] args) {
        int rows, columns, temp = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of rows in matrix:");
        rows = s.nextInt();
        System.out.print("Enter number of columns in matrix:");
        columns = s.nextInt();
        if (rows == columns) {
            int a[][] = new int[rows][columns];
            System.out.println("Enter all the elements of matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    a[i][j] = s.nextInt();
                }
            }
            System.out.println("Given Matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println("");
            }
            for (int j = 0; j < columns; j++) {
                temp = a[j][j];
                a[j][j] = a[j][columns - 1 - j];
                a[j][columns - 1 - j] = temp;
            }
            System.out.println("Matrix after interchanging diagonals");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("Rows not equal to column");
        }
    }
}
