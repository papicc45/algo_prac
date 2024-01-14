package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        for(int i=1 ; i<=n ; i++) {
            String str = br.readLine();
            for(int j=1 ; j<=m ; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j-1, j));
            }
        }

        int[][] dp = new int[n+1][m+1];
        for(int i=1 ; i<=n ; i++) {
            int j=1;
            if(arr[i][j] == 1) {
                dp[i][j] = dp[i-1][j] + 1;
            }
            for(j=2 ; j<=n ; j++) {
                if(arr[i][j] == 1) {
                    dp[i][j] = dp[i][j-1] + 1;
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=m ; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}
