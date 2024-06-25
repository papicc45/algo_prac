package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        int[] dp = new int[k+1];
        Arrays.fill(dp, 987654321);
        for(int i=0 ; i<n ; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if(coins[i] <= k) {
                dp[coins[i]] = 1;
            }
        }

        for(int i=1 ; i<=k ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if(dp[k] == 987654321)
            System.out.println("-1");
        else
            System.out.println(dp[k]);
    }
}
