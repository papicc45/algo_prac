package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[302][302];
        int[][] arr = new int[302][302];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[y+1][x+1] = m - y - x;
        }

        for(int i=1 ; i<=301 ; i++) {
            for(int j=1 ; j<=301 ; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }

        System.out.println(dp[301][301]);
    }
}
