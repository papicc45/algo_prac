package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        long[][]dp = new long[n+1][21];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        dp[1][arr[1]] = 1;

        for(int i=2 ; i<n ; i++) {
            for(int j=0 ; j<=20 ; j++) {
                if(dp[i-1][j] == 0)
                    continue;

                if(j - arr[i] >= 0) {
                    dp[i][j-arr[i]] += dp[i-1][j];
                }
                if(j + arr[i] <= 20) {
                    dp[i][j+arr[i]] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n-1][arr[n]]);
    }
}
