import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] arr = new double[n];

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

       
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextDouble();

            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<Double>());
        }

        for (int i = 0; i < n; i++) {

            double value = arr[i];

            int index;

            if (max == min) {
                index = 0;
            } else {
                index = (int)(((value - min) / (max - min)) * n);
            }

            if (index == n) {
                index = n - 1;
            }

            buckets.get(index).add(value);
        }

    
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets.get(i));
        }

        for (int i = 0; i < n; i++) {

            for (double value : buckets.get(i)) {

                if (value != (int)value) {
                    System.out.printf("%.2f ", value);
                } else {
                    System.out.printf("%.0f ", value);
                }
            }
        }

        System.out.println();
    }
}
