package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n];

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for(int i=1 ; i<n ; i++) {
            for(int j=0 ; j<i ; j++) {
                dp[i] = Math.min(dp[i], Math.max(dp[j], (long) (i - j) * (1 + Math.abs(arr[i] - arr[j]))));
            }
        }

        System.out.println(dp[n-1]);
    }
}
