package dynamicprogramming;

import java.util.Scanner;

public class BOJ_24464 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] dp = new long[n + 1][5];

        for (int i = 0; i < 5; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    //안먹을 때
                    for (int k = 1; k < 5; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= 1000000007;
                    }
                } else {
                    if (j == 1) {
                        dp[i][j] += dp[i - 1][3] + dp[i - 1][4];
                        dp[i][j] %= 1000000007;
                    } else if (j == 2) {
                        dp[i][j] += dp[i - 1][4];
                        dp[i][j] %= 1000000007;
                    } else if (j == 3) {
                        dp[i][j] += dp[i - 1][1];
                        dp[i][j] %= 1000000007;
                    } else {
                        dp[i][j] += dp[i - 1][1] + dp[i - 1][2];
                        dp[i][j] %= 1000000007;
                    }
                    dp[i][j] += dp[i - 1][0];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        long result = 0;
        for(int i=0 ; i<5 ; i++) {
            result += dp[n][i];
            result %= 1000000007;
        }
        System.out.println(result);
    }
}
