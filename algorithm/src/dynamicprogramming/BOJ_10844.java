package dynamicprogramming;

import java.util.Scanner;

public class BOJ_10844 {
    static long MOD = 1_000_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] dp = new long[101][10];

        for(int i=1 ; i<=9 ; i++) {
            dp[1][i] = 1;
        }

        for(int i=2 ; i<101 ; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for(int j=1 ; j<=8 ; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }

        long sum = 0;
        for(int i=0 ; i<10 ; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        System.out.println(sum);
    }
}
