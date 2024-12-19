import java.util.Scanner;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 7, 7, 7, 7, 9, 62, 74, 89, 90, 100};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target: ");
        int target = sc.nextInt();
        int[] ans = searchIndex(arr, target);
        System.out.println("First Position: " + ans[0] + ", Last Position: " + ans[1]);
    }

    public static int[] searchIndex(int[] arr, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(arr, target, true);  // Find first occurrence
        if (ans[0] != -1) {                         
            ans[1] = search(arr, target, false); // Find last occurrence
        }
        
        return ans;
    }

    public static int search(int[] arr, int target, boolean findFirstIndex) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                // Potential answer found
                ans = mid;
                if (findFirstIndex) {
                    end = mid - 1; // Narrow down to find first occurrence
                } else {
                    start = mid + 1; // Narrow down to find last occurrence
                }
            }
        }
        return ans;
    }
}
