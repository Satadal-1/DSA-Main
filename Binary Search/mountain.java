public class mountain {
    // The question is to find the max element in the array. we will find it by
    // using binary search
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 6, 8, 4, 3, 2 };
        System.out.println(findPeak(arr));
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
        return arr[start];
    }
}
