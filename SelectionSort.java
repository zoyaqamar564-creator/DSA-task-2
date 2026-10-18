import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    // Time Complexity:
    // Best: O(n^2)
    // Average: O(n^2)
    // Worst: O(n^2)
    // Space: O(1)

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with arr[i]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();

        // Generate random values
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }

        long start = System.nanoTime();

        selectionSort(arr);

        long end = System.nanoTime();

        System.out.println("Selection Sort");
        System.out.println("Array Size: " + arr.length);
        System.out.println("Time: " + (end - start) / 1_000_000.0
                           + " milliseconds");
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}