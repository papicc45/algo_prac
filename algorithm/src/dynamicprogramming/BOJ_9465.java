package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] up = new int[n];
            int[] down = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ; i++) {
                up[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ; i++) {
                down[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n][2];
            dp[0][0] = down[0];
            dp[0][1] = up[0];

            for(int i=1 ; i<n ; i++) {
                dp[i][0] = Math.max(dp[i-1][0], down[i] + dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-1][1], up[i] + dp[i-1][0]);
            }

            System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
            t--;
        }

    }
}
