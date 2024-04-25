package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_3067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0 ; tc<t ; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];
            dp[0] = 1;
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<=m ; j++) {
                    if(j - coins[i] >= 0)
                        dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(dp[m]);
        }
    }
}
