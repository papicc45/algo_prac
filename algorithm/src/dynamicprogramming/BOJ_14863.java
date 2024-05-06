package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][4];

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
            // 0 - 도보시간, 1 - 도보모금액, 2 - 자전거시간 , 3 - 자전거모금액
        }
        int[][] dp = new int[n+1][k+1];
        dp[1][arr[1][0]] = arr[1][1];
        dp[1][arr[1][2]] = Math.max(dp[1][arr[1][2]], arr[1][3]);

        for(int i=2 ; i<=n ; i++) {
            for(int j=0 ; j<=k ; j++) {
                if(dp[i-1][j] != 0) {

                    if(j + arr[i][0] <= k) {
                        dp[i][j + arr[i][0]] = Math.max(dp[i][j + arr[i][0]], dp[i-1][j] + arr[i][1]);
                    }

                    if(j + arr[i][2] <= k) {
                        dp[i][j + arr[i][2]] = Math.max(dp[i][j + arr[i][2]], dp[i-1][j] + arr[i][3]);
                    }
                }
            }
        }

        int result = 0;
        for(int i=1 ; i<=k ; i++) {
            result = Math.max(result, dp[n][i]);
        }
        System.out.println(result);
    }
}
