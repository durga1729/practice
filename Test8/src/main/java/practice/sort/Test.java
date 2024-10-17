package practice.sort;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Test {

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int a = m - l + 1;
        int b = r - m;

        int[] L = new int[a];
        int[] R = new int[b];

        for (int i = 0; i < a; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < b; j++) {
            R[j] = arr[m + 1 + j];
        }

        int k = l;
        int i = 0, j = 0;
        while (i < a && j < b) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < a) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < b) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        // Calling of Merge Sort
        Test ob = new Test();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
