package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] orange = new int[n+1];
        long[] dp = new long[n+1];

        for(int i=1 ; i<=n ; i++) {
            orange[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for(int i=1 ; i<=n ; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j=i ; j>=Math.max(1, i-m+1) ; j--) {
                max = Math.max(max, orange[j]);
                min = Math.min(min, orange[j]);
                int cnt = i - j + 1;
                long cost = k + (long)(cnt * (max - min));
                dp[j] = Math.min(dp[j], cost + dp[i-1]);
            }
        }
        System.out.println(dp[n]);
    }
}
