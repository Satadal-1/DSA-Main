import java.util.Scanner;

public class FloorBS {
    //returns the smallest number >= target;
    public static int Floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // Early check if the number is less then the largest element
        if (target < arr[start]) {
            return -1;
        }
        // normally search for the element is present in the array or not
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;

            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        // the end will become the floor element if the element is not present in the
        // array, after the while loop condition
        return end;
    }

    public static void main(String args[]) {
        int[] arr = { -12, -5, -3, 1, 2, 5, 19, 23, 34, 66, 78, 97 };
        System.out.println("Enter The number you want to find Floor");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int ans = Floor(arr, target);

        if (ans != -1) {
            System.out.println("Floor found at index: " + ans);
        } else {
            System.out.println("Floor not found");
        }

    }
}