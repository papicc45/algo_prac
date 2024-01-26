package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];

        int[] weights = new int[n+1];
        int[] values = new int[n+1];

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1 ; i<=k ; i++) {
            for(int j=1 ; j<=n ; j++) {
                dp[j][i] = dp[j-1][i];
                if(i - weights[j] >= 0)
                    dp[j][i] = Math.max(dp[j-1][i], values[j] + dp[j-1][i - weights[j]]);
            }
        }

        System.out.println(dp[n][k]);
    }
}
