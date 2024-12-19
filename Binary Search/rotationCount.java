import java.util.Scanner;

public class rotationCount {
    public static void main(String[] args) {
          int[] arr = { 7, 9, 10, 12, 14, 18, 1, 2, 3, 6 };
        Scanner sc = new Scanner(System.in);
        
        int ans = findRotationCount(arr);
        System.out.println("The array is rotated " + (ans+1) + " times");
    }
    static int findRotationCount(int[] arr) {
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
}
