package dynamicprogramming;

import java.io.BufferedReader;
import java.util.Scanner;

public class BOJ_4811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] dp = new long[31][31];

        for(int w=0 ; w<=30 ; w++) {
            for(int h=0 ; h<=30 ; h++) {
                if(h > w) continue;
                if(h == 0) dp[w][h] = 1;
                else dp[w][h] = dp[w-1][h] + dp[w][h-1];
            }
        }
        while (true) {
            int n = sc.nextInt();
            if(n == 0) break;

            System.out.println(dp[n][n]);
        }
    }
}
