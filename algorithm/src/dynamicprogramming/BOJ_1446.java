package dynamicprogramming;

import java.awt.event.HierarchyBoundsAdapter;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] highway = new int[d+1][d+1];
        int[] dp = new int[d+1];
        for(int i=0 ; i<=d ; i++) {
            dp[i] = i;
        }

        for(int i=0 ; i<=d ; i++) {
            Arrays.fill(highway[i], Integer.MAX_VALUE);
        }
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if(start > d || end > d)
                continue;
            highway[start][end] = Math.min(highway[start][end], len);
        }

        for(int i=0 ; i<=d ; i++) {
            for(int j=0 ; j<=d ; j++) {
                if(highway[i][j] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[i] + highway[i][j]);
                } else {
                    if(j != 0) {
                        dp[j] = Math.min(dp[j], dp[j-1] + 1);
                    }
                }
            }
        }
        System.out.println(dp[d]);


    }
}
