package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        int[] woks = new int[m];

        st = new StringTokenizer(br.readLine());
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0 ; i<m ; i++) {
            woks[i] = Integer.parseInt(st.nextToken());
            dp[woks[i]] = 1;
        }


        for(int i=1 ; i<=n ; i++) {
            for(int j=0 ; j<woks.length ; j++) {
                if(i - woks[j] >= 0 && dp[i - woks[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - woks[j]] + 1);
                }
            }
        }
        if(dp[n] == 0)
            System.out.println("-1");
        else
            System.out.println(dp[n]);
    }
}
