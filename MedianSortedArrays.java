import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;

        int count = 0;

        int prev = 0;
        int curr = 0;

        int total = n + m;

     
        while (count <= total / 2) {

            prev = curr;

            if (i < n && (j >= m || a[i] <= b[j])) {
                curr = a[i];
                i++;
            } else {
                curr = b[j];
                j++;
            }

            count++;
        }

       
        if (total % 2 == 0) {

            System.out.printf("%.1f", (prev + curr) / 2.0);

        } 
 
        else {

            System.out.printf("%.1f", (double) curr);
        }

        sc.close();
    }
}
