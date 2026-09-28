import java.util.*;

public class Solution {

    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        return dividend / divisor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dividend = sc.nextInt();
        int divisor = sc.nextInt();

        System.out.println(divide(dividend, divisor));

        sc.close();
    }
}
