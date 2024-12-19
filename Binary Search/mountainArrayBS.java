import java.util.Scanner;
public class mountainArrayBS {
    public static void main(String[] args) {
        int[] arr= { 1, 2, 3, 5, 6, 8, 4, 3, 2};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Target");
        int tar = sc.nextInt();
        int ans = mountainBS(arr , tar);
        if (ans != -1 ) {
            System.out.println("The number found at Index: " + ans);
        } else {
            System.out.println("The number not found.  lawde array me se kuch number de"); 
        }
    }
    static int mountainBS(int[] arr, int target){
        int peak = findPeak(arr);
        int Firsttry = orderAgnostic(arr, target, 0, peak);
        int Secondtry= orderAgnostic(arr, target, peak+1, arr.length -1);
        if (Firsttry != -1) {
            //result found in asc part
            return Firsttry;
        }else{
            // result is on dec part
            return Secondtry;
        }
    }
    static int orderAgnostic(int arr[], int target, int start, int end) {
       
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
    static int findPeak(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // we are in asc part of the array
                start = mid + 1;
            } else {
                // we are in the dec part of the array
                end = mid;
            }

        }
        return start;
    }
    
}