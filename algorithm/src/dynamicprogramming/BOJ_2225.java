package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2225 {
    static int n, k;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new long[n+1][k+1];
        for(int i=1 ; i<=k ; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[n][k]);
    }
}
