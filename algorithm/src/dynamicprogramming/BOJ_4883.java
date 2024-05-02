package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            int[][] arr = new int[n][3];
            int[][] dp = new int[n][3];
            for(int i=0 ; i<n ; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            }

            for(int i=0 ; i<n ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][2];
            for(int i=1 ; i<n ; i++) {
                if(i == 1) {
                    dp[i][0] = dp[i-1][1] + arr[i][0];
                    dp[i][1] = Math.min(dp[i][0], Math.min(dp[i-1][1], dp[i-1][1] + dp[i-1][2])) + arr[i][1];
                    dp[i][2] = Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][1] + dp[i-1][2])) + arr[i][2];
                } else {
                    dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][0];
                    dp[i][1] = Math.min(dp[i][0], Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i-1][0]))) + arr[i][1];
                    dp[i][2] = Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2])) + arr[i][2];
                }
            }
            System.out.println(num++ + ". " + dp[n-1][1]);
        }
    }
}
