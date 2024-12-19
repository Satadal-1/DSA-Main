import java.util.Scanner;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = { -12, -5, -3, 1, 2, 5, 19, 23, 34, 66, 78, 97, 100, 132, 143, 187, 198, 234, 276, 287, 290, 300,
                341 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Target : ");
        int target = sc.nextInt();
        int ans = InfiniteArray(arr, target);
        if(ans != -1){
            System.out.println("Target found at index :" + ans);
        }else{
            System.out.println("Target not found");
        }

    }

    static int InfiniteArray(int arr[], int target) {
        int start = 0;
        int end = 1;
        // checking for the first box
        // if the target element is outside the box the box will move into the next box
        // that means my new start and end will be changed
        // now the next box will be doublled
        while(arr[end] < target){
            int newStart = end +1; // this is new start
            // new end = end + new doublled length
            int newEnd = end + (end -start +1);
            start = newStart;
            end = newEnd;
        }
        return binarySearch(arr, target, start, end);


    }

    static int binarySearch(int arr[], int target, int start, int end) {
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
