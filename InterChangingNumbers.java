import java.io.*;
import java.util.*;

public class InterChangingNumbers{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int largestValue = Integer.MIN_VALUE;
        int smallestValue = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            largestValue = Math.max(largestValue, arr[i]);
            smallestValue = Math.min(smallestValue, arr[i]);
        }

        int idx1 = 0, idx2 = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == smallestValue) {
                idx1 = i;
            }
            if (arr[i] == largestValue) {
                idx2 = i;
            }
        }
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}