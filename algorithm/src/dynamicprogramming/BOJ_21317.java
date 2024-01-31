package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[24][2];
        int[][] dp = new int[24][2];

        for(int i=1 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=1 ; i<=23 ; i++) {
            Arrays.fill(dp[i], 987654321);
        }
        dp[1][0] = 0;
        dp[1][1] = 0;
        int k = Integer.parseInt(br.readLine());
        for(int i=1 ; i<n ; i++) {
            dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0] + arr[i][0]);
            dp[i+2][0] = Math.min(dp[i+2][0], dp[i][0] + arr[i][1]);
            dp[i+3][1] = dp[i][0] + k;

        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}
