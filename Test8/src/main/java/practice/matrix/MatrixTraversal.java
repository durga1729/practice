package practice.matrix;

public class MatrixTraversal {

    public static void printMatrix(int matrix[][])
    {
        for (int i = 0; i < matrix.length; i++)
        {
            // length returns number of rows
            for (int j = 0; j < matrix[i].length; j++)
            {
                // here length returns number of columns corresponding to current row
                // using tabs for equal spaces, looks better aligned
                // matrix[i][j] will return each element placed at row ‘i',column 'j'
                System.out.print( matrix[i][j]  + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = { { 3, 2, 1, 7 },
                { 9, 11, 5, 4 },
                { 6, 0, 13, 17 },
                { 7, 21, 14, 15 } };
        printMatrix(matrix);
    }
}