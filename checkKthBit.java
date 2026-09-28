import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int mask = 1 << k;

        if ((n & mask) != 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }
}
