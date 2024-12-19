import java.util.Scanner;
//this is a problem of rotated array
//This is a leetcode medium qustion

public class rotatedArrayBS {
    public static void main(String[] args) {
        int[] arr = { 7, 9, 10, 12, 14, 18, 1, 2, 3, 6 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Target");
        int tar = sc.nextInt();
        int ans = rotatedBS(arr, tar);
        if (ans != -1) {
            System.out.println("The number found at Index: " + ans);
        } else {
            System.out.println("The number not found.  lawde array me se kuch number de");
        }
    }

    // This code will not run for duplicate values
    public static int rotatedBS(int[] arr, int target) {
        int pivot = findPivotIndexInRotatedArray(arr);
        if (pivot == -1) {
            // pivot not found so normal binary search
            binarySearch(arr, target, 0, arr.length - 1);
        }
        if (arr[pivot] == target) {
            return pivot;
        }
        if (arr[0] < target) {
            // the target will lie between start and pivot
            return binarySearch(arr, target, 0, pivot - 1);
        }
        // The number will lie between pivot+1 till end
        return binarySearch(arr, target, pivot + 1, arr.length - 1);
    }

    static int findPivotIndexInRotatedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // There will be four cases for finding the peak element in the rotated array

            // case 1:
            if (mid < arr.length && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // case 2:
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // case 3:
            if (arr[start] > arr[mid]) {
                end = mid - 1;

            }
            // case 4:
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            // accending order
            // now we have to find the mid point. but for the bigger integer start + end
            // value may be bigger than integer range. That's why we will use different
            // formula to find mid value that is start + (end - start)/2;
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;

            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
