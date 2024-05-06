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
        int[][] arr = new int[21][2];
        for(int i=1 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[21][2];
        for(int i=0 ; i<=n ; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[1][0] = 0;
        dp[2][0] = arr[1][0];
        dp[3][0] = Math.min(dp[2][0] + arr[2][0], arr[1][1]);
        for(int i=4 ; i<=n ; i++) {
            dp[i][0] = Math.min(dp[i-1][0] + arr[i-1][0], dp[i-2][0] + arr[i-2][1]);
            dp[i][1] = Math.min(dp[i-3][0] + k, Math.min(dp[i-1][1] + arr[i-1][0], dp[i-2][1] + arr[i-2][1]));
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}
