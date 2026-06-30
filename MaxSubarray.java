import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSubarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] arr=new int[a];
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a;i++){
            sum+=arr[i];
            if(sum<0){
                sum=0;
            }
             max=Math.max(max,sum);
        }
        System.out.print(max);
    }
}
