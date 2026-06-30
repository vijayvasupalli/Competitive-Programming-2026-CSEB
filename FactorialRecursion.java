import java.util.*;

public class FactorialRecursion{

    public static int fac(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * fac(num - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int result = fac(num);

        System.out.println(result);
    }
}