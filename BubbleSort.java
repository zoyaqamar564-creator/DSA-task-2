import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    // Time Complexity:
    // Best: O(n) with optimization
    // Average: O(n^2)
    // Worst: O(n^2)
    // Space: O(1)

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {

                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop if array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }

        long start = System.nanoTime();

        bubbleSort(arr);

        long end = System.nanoTime();

        System.out.println("Bubble Sort");
        System.out.println("Array Size: " + arr.length);
        System.out.println("Time: " + (end - start) / 1_000_000.0
                           + " milliseconds");
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}