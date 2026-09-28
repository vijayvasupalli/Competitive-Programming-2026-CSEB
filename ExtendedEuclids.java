import java.util.*;

public class Main {

    static long[] gcd(long a, long b) {
        if (b == 0)
            return new long[]{a, 1, 0};

        long[] r = gcd(b, a % b);

        long d = r[0];
        long x = r[2];
        long y = r[1] - (a / b) * r[2];

        return new long[]{d, x, y};
    }

    static long[] best(long A, long B, long x0, long y0, long D) {
        long p = B / D;
        long q = A / D;

        long bestX = x0;
        long bestY = y0;
        long bestSum = Math.abs(x0) + Math.abs(y0);

        long k1 = -x0 / p;
        long k2 = y0 / q;

        for (long k = Math.min(k1, k2) - 3;
             k <= Math.max(k1, k2) + 3; k++) {

            long x = x0 + k * p;
            long y = y0 - k * q;

            long sum = Math.abs(x) + Math.abs(y);

            if (sum < bestSum ||
                (sum == bestSum && x <= y && bestX > bestY)) {

                bestSum = sum;
                bestX = x;
                bestY = y;
            }
        }

        return new long[]{bestX, bestY};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] r = gcd(A, B);

        long D = r[0];
        long x0 = r[1];
        long y0 = r[2];

        long[] ans = best(A, B, x0, y0, D);

        System.out.println(ans[0] + " " + ans[1] + " " + D);
    }
}
