import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       int amount=sc.nextInt();
       int size=sc.nextInt();
       int[] coins=new int[size];
       for(int i=0;i<size;i++){
        coins[i]=sc.nextInt();
       }
       int[] dp=new int[amount+1];
       Arrays.fill(dp,amount+1);
       dp[0]=0;
       
       for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin<=i){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }   
       }
       System.out.println(dp[amount]>amount?-1:dp[amount]);
    }
}
