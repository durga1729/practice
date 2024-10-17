package practice.sort;// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class QuickSort {

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            sort(arr, l, pivot - 1);
            sort(arr, pivot + 1, r);
        }
    }

    public int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;

        return i + 1;
    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {90, 34, 25, 12, 64, 11, 03};

        System.out.println("Given Array");
        printArray(arr);

        // Calling of Merge Sort
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}