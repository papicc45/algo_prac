package dynamicprogramming;

import java.util.Scanner;

public class BOJ_14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for(int i=0 ; i<=n ; i++) {
            dp[i] = i;
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=2 ; j<=i/2 ; j++) {
                if(i % j == 0) {
                    int before = dp[i/j];
                    int div = i / j;
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
        }
        for(int i=1 ; i<n ; i++) {
            dp[i] = Math.min(dp[i], dp[i+1] + 1);
        }
        System.out.println(dp[n]);

    }
}
