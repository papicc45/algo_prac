package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        for(int i= 1; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i-1];
        }

        int[][] dp = new int[4][n+1];
        int m = Integer.parseInt(br.readLine());
        for(int i=1 ; i<=3 ; i++) {
            for(int j=i*m ; j<=n ; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-m] + arr[j] - arr[j-m]);
            }
        }

        System.out.println(dp[3][n]);
    }
}
