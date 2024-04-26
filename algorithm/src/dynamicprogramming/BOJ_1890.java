package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n+1][n+1];
        dp[1][1] = 1;
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                int len = arr[i][j];

                if(len == 0)
                    break;

                if(i + len <= n)
                    dp[i+len][j] += dp[i][j];
                if(j + len <= n)
                    dp[i][j+len] += dp[i][j];
            }
        }
        System.out.println(dp[n][n]);

    }
}
