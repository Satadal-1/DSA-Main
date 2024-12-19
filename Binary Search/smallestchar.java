import java.util.Scanner;

public class smallestchar {
    // leetcode qsn , same as the ceiling problem..
    public static void main(String[] args) {
        char arr[] = { 'a', 'c', 'f', 'i', 'm' };
        System.out.println("Enter the character whos next bigger character you want to search: ");
        Scanner sc = new Scanner(System.in);
        char target = sc.next().charAt(0);
        char ans = nextchar(arr, target);
        System.out.println("The next smallest element grater than this element is: " + ans);

    }

    public static char nextchar(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;
        // loop will run when start <= end
        while (s <= e) {
            int mid = s + (e - s) / 2;
            // This conditions are for accending arrays
            if (letters[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        // it will return the first elemet which is at index no '0' if the ans is grater
        // than the last element;
        //because in the question they says the array is wrapped in loops.
        return letters[s % letters.length];
    }
}
