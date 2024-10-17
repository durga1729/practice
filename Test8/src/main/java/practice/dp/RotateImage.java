package practice.dp;

public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transposeMatrix(arr);
        reverseMatrix(arr);
        printMatrix(arr);
    }

    public static void transposeMatrix(int matrix[][]) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public static void reverseMatrix(int matrix[][]) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; ++j, k--) {
                swap(matrix, i, j, i, k);
            }
        }
    }

    public static void swap(int matrix[][], int i, int j, int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }

    public static void printMatrix(int[][] arr) {
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length;j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
