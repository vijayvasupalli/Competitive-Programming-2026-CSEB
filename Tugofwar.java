import java.io.*;
import java.util.*;

public class Solution {

    static int[] arr;
    static int n;
    static int need;
    static int total;
    static int answer = Integer.MAX_VALUE;

    static void generate(int index, int end, int count, int sum) {

        if (index == end) {
            if (count == need) {
                int other = total - sum;
                answer = Math.min(answer, Math.abs(sum - other));
            }
            return;
        }

        generate(index + 1, end, count, sum);

        generate(index + 1, end, count + 1, sum + arr[index]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        need = n / 2;

        generate(0, n, 0, 0);

        System.out.println(answer);
    }
}
