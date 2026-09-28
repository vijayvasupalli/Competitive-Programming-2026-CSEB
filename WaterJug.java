import java.io.*;
import java.util.*;

public class Solution {

    public static int gcd(int a, int b) {

        int gcd = 1;

        while (a != b) {

            if (a == 0) {
                return b * gcd;
            }

            if (b == 0) {
                return a * gcd;
            }

            if (a % 2 == 0 && b % 2 == 0) {
                a = a / 2;
                b = b / 2;
                gcd = gcd * 2;
            }
            else if (a % 2 == 0) {
                a = a / 2;
            }
            else if (b % 2 == 0) {
                b = b / 2;
            }
            else if (a > b) {
                a = (a - b) / 2;
            }
            else {
                b = (b - a) / 2;
            }
        }

        return a * gcd;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int T = sc.nextInt();

        int g = gcd(A, B);

        if (T == 0) {
            System.out.println("YES");
        }
        else if (T <= Math.max(A, B) && T % g == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
