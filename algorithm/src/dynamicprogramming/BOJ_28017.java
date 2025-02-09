package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];
        int[][] weapons = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                weapons[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i - 1][k] + weapons[i][k], dp[i][j]);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=1 ; i<=m ; i++) {
            result = Math.min(dp[n][i], result);
        }

        System.out.println(result);
    }
}
