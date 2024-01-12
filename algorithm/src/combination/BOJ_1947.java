package combination;

import java.util.Scanner;

public class BOJ_1947 {
    static int MOD = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] dp = new long[1000001];
        int n = sc.nextInt();

        dp[1] = 0;
        dp[2] = 1;
        for(int i=3 ; i<=n ; i++) {
            dp[i] = (i - 1) * (dp[i-2] + dp[i-1]) % MOD;
        }
        System.out.println(dp[n]);

    }
}
