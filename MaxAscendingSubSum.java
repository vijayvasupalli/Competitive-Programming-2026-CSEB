import java.util.*;

public class Solution {

    public static int maxAscendingSum(int[] arr) {

        int n = arr.length;

        int i = 0;  
        int j = 1; 

        int sum = arr[0];
        int maxSum = arr[0];

        while (j < n) {

            if (arr[j] > arr[j - 1]) {
                sum += arr[j];
            } 
            else {
                i = j;
                sum = arr[j];
            }

            maxSum = Math.max(maxSum, sum);

            j++;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int k = 0; k < n; k++) {
            arr[k] = sc.nextInt();
        }

        System.out.println(maxAscendingSum(arr));
    }
}
