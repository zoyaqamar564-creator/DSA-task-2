import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    // Time Complexity:
    // Best: O(n log n)
    // Average: O(n log n)
    // Worst: O(n log n)
    // Space: O(n)

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Divide the array into two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left,
                             int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Compare and merge elements
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from L
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements from R
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }

        long start = System.nanoTime();

        mergeSort(arr, 0, arr.length - 1);

        long end = System.nanoTime();

        System.out.println("Merge Sort");
        System.out.println("Array Size: " + arr.length);
        System.out.println("Time: " + (end - start) / 1_000_000.0
                           + " milliseconds");
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}