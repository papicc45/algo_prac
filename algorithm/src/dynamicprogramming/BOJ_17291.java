package dynamicprogramming;

import java.util.Scanner;

public class BOJ_17291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++) {
            dp[i] = dp[i-1] * 2;
            if(i-3 >= 0 && (i-3) % 2 == 1) {
                dp[i] = dp[i] - (dp[i-3] / 2);
            }

            if(i-4 >= 0 && (i-4) % 2 == 0) {
                dp[i] = dp[i] - (dp[i-4] / 2);
            }
        }

        System.out.println(dp[n]);
    }
}
