import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        while (b != 0) {
            int carry = (a & b) << 1; 
            a = a ^ b;                
            b = carry;              
        }

        System.out.println(a);

        sc.close();
    }
}
