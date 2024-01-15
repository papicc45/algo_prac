package dynamicprogramming;

import java.util.Scanner;

public class BOJ_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4 ; i<12 ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();

            System.out.println(dp[n]);
            t--;
        }
    }
}
