package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] memories = new int[n+1][2];
        //0 - 차지하는 메모리 양, 1 - 비활성화 했을경우 비용

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            memories[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            memories[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][10001];

        int result = Integer.MAX_VALUE;
        for(int i=1 ; i<=n ; i++) {
            for(int j=0 ; j<=10000 ; j++) {
                if(j >= memories[i][1]) {
                    if(i == 1)
                        dp[i][j] = memories[i][0];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-memories[i][1]] + memories[i][0]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= m)
                    result = Math.min(result, j);
            }
        }
        System.out.println(result);
    }
}
