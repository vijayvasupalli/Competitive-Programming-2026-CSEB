import java.util.Scanner;

public class BinaryGCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = 1;

        while (a != b) {
            if (a == 0) {
                System.out.println(b);
                return;
            }

            if (b == 0) {
                System.out.println(a);
                return;
            }

            if (a % 2 == 0 && b % 2 == 0) {
                a = a / 2;
                b = b / 2;
                gcd = gcd * 2;
            } else if (a % 2 == 0) {
                a = a / 2;
            } else if (b % 2 == 0) {
                b = b / 2;
            } else if (a > b) {
                a = (a - b) / 2;
            } else {
                b = (b - a) / 2;
            }
        }

        System.out.println(a * gcd);
    }
}
