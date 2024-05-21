package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=2 ; i<n ; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;;
            for(int j=i ; j>=1 ; j--) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j-1]);
            }
        }
    }
}
