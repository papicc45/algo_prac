package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[t+1][w+1][3];
        int[] jadu = new int[t+1];
        for(int i=1 ; i<=t ; i++) {
            jadu[i] = Integer.parseInt(br.readLine());
        }
        if(jadu[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }
        for(int i=2 ; i<=t ; i++) {

            if(jadu[i] == 1) {
                dp[i][0][1] = dp[i-1][0][1] + 1;
                dp[i][0][2] = dp[i-1][0][2];

                for(int j=1 ; j<=w ; j++) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);
                }
            } else {
                dp[i][0][1] = dp[i-1][0][1];
                dp[i][0][2] = dp[i-1][0][2] + 1;

                for(int j=1 ; j<=w ; j++) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]) + 1;
                }
            }
        }
        int result = 0;
        for(int i=0 ; i<=w ; i++) {
            result = Math.max(result, Math.max(dp[t][i][1], dp[t][i][2]));
        }
        System.out.println(result);
    }
}
