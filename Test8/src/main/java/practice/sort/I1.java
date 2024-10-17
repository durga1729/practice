package practice.sort;

public class I1 {

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[]) {
        I1 ob = new I1();
        int arr[] = {90, 34, 25, 12, 64, 11, 03};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
