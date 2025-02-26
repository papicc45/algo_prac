package dynamicprogramming;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14628 {
    static int n, m, k;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());

        int[][] v = new int[n + 1][2];
        dp = new int[110][110];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (int)1e9;
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int p = j / v[i][1]; p >= 0; p--) {
                    int prevIdx = j - v[i][1] * p;
                    int cost = dp[i - 1][prevIdx] + v[i][0] * p + k * (p * (p - 1) / 2);

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
