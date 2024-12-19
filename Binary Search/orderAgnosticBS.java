import java.util.Scanner;

public class orderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = { -12, -3, 1, 2, 5, 7, 8, 9, 12, 34, 56, 78, 98 };
        System.out.println("Enter the number you want to search: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int ans = orderAgnostic(arr, target);
        if (ans != -1) {
            System.out.println("Element found at index: " + ans);
        } else {
            System.out.println("Element not found");
        }
    }

    public static int orderAgnostic(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        // check if the array is in accending order or not
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] ==target ) {
                return mid;
            }
            if (isAsc) {
                // Array is in accending order
                if (arr[mid] > target) {
                    end = mid - 1;

                } else if (arr[mid] < target) {
                    start = mid + 1;
                }

            } else {
                // Array is in decending order
                if (arr[mid] < target) {
                    end = mid - 1;

                } else if (arr[mid] > target) {
                    start = mid + 1;
                }

            }
        }
        return -1;

    }
}
