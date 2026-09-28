import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = mat[0][0];
        for(int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + mat[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int minPrevious = Math.min(
                    dp[i - 1][j],                    
                    Math.min(dp[i][j - 1],           
                             dp[i - 1][j - 1])       
                );
                dp[i][j] = mat[i][j] + minPrevious;
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
    }
