package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][2];
        for(int i=1 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();

            int p = Integer.parseInt(st.nextToken());
            if(i == 1) {
                dp[i][0] = 0;
                dp[i][1] = p;
            } else {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-2][1], dp[i-1][0]) + p;
            }
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
