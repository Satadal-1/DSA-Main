package cycle_sort;

import java.util.Arrays;

public class cyclesort {
    public static void main(String[] args) {
        int[] array = {1, 5, 6, 4, 3, 2, 8, 7}; // Input array
        sort(array); // Sort the array using Cycle Sort
        System.out.println(Arrays.toString(array)); // Print the sorted array
    }

    static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1; // Calculate the correct position for arr[i]
            if (arr[i] != arr[correct]) { // If arr[i] is not in its correct position
                swap(arr, i, correct); // Swap arr[i] with arr[correct]
            } else {
                i++; // Move to the next element if it's already in the correct position
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first]; // Store the value of the first element
        arr[first] = arr[second]; // Assign the value of the second element to the first
        arr[second] = temp; // Assign the value of temp to the second element
    }
}
