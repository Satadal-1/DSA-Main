import java.util.Arrays;

public class MergSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 3, 1, 5};
        arr = mergSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] left = mergSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from first array
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        // Copy remaining elements from second array
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}
