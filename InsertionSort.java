import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    // Time Complexity:
    // Best: O(n)
    // Average: O(n^2)
    // Worst: O(n^2)
    // Space: O(1)

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move larger elements one position to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }

        long start = System.nanoTime();

        insertionSort(arr);

        long end = System.nanoTime();

        System.out.println("Insertion Sort");
        System.out.println("Array Size: " + arr.length);
        System.out.println("Time: " + (end - start) / 1_000_000.0
                           + " milliseconds");
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}