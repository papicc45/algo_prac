package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n+1][m][3];
        for(int i=1 ; i<=n ; i++) {
            for(int j=0 ; j<m ; j++) {
                Arrays.fill(dp[i][j], 1000 * 1000 * 100);
            }
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(j == 0) {

                } else if(j == m-1) {

                } else {

                }
            }
        }

    }
}
