package practice.matrix;


class LowerTraingle {
    static void print(int[][] mat) {
     //   System.out.print("The matrix in Snake pattern is : ");
        // Traverse through all rows

        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If current row is even, print from
                // left to right
                if (i < j) {
                    System.out.print("0 " + " ");
                } else {
                    System.out.print(mat[i][j]+" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int mat[][] = new int[][]
                {
                        { 10, 20, 30, 40 },
                        { 15, 25, 35, 45 },
                        { 27, 29, 37, 48 },
                        { 32, 33, 39, 50 }
                };
        print(mat);
    }
}