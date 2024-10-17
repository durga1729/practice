package org.example;

import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[][] = spiralMatrixII(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] spiralMatrixII(int n) {
        int matrix [][] = new int[n][n];
        int num = 1;

        int topRow = 0, bottomRow = n-1, leftCol = 0, rightCol = n-1;
        while (leftCol  <= rightCol && topRow <= bottomRow) {

            //fill top row
            for (int i=leftCol;i<=rightCol;i++) {
              matrix[topRow][i] = num++;
            }
            topRow++;

            //fill right column
            for (int i=topRow;i<=bottomRow;i++) {
                matrix[i][rightCol] = num++;
            }
            rightCol--;


            //fill bottom row
            if (topRow <= bottomRow) {
                for (int i=rightCol;i>=leftCol;i--) {
                    matrix[bottomRow][i] = num++;
                }
                bottomRow--;
            }

            //fill left col
            if (leftCol <= rightCol) {
                for (int i=bottomRow;i>=topRow;i--) {
                    matrix[i][leftCol] = num++;
                }
                leftCol++;
            }

        }

        return matrix;
    }
}
