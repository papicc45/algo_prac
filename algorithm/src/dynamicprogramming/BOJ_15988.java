package dynamicprogramming;

import java.io.BufferedReader;
import java.util.Scanner;

public class BOJ_15988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long[] dp = new long[n+1];
            for(int i=1 ; i<=n ; i++) {
                if(i == 1)
                    dp[i] = 1;
                else if(i == 2)
                    dp[i] = 2;
                else if(i == 3)
                    dp[i] = 4;
                else {
                    dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
                }
            }
            System.out.println(dp[n] % 1000000009);
        }
    }
}
