import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();

        for (int i = 1; i <= n; i++) {

            if (n % i != 0) {
                continue;
            }

            String prefix = s.substring(0, i);

            StringBuilder repeated = new StringBuilder();


            for (int j = 0; j < n / i; j++) {
                repeated.append(prefix);
            }

            if (repeated.toString().equals(s)) {
                System.out.println(i);
                break;
            }
        }
    }
}
