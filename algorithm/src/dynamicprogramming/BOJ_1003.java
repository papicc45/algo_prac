package dynamicprogramming;

import java.util.Scanner;

public class BOJ_1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[1][1] = 1;
        for(int i=2 ; i<41 ; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
        while (t > 0) {
            int n = sc.nextInt();

            System.out.println(dp[n][0] + " " + dp[n][1]);
            t--;
        }
    }
}
