package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][40001];
        for(int i=1 ; i<=n ; i++) {
            dp[1][arr[i]] = 1;
        }

        for(int i=2 ; i<=n ; i++) {
            for(int j=1 ; j<=40000 ; j++) {
                if(dp[i-1][j] != 0) {

                    if(j + arr[i] <= 40000) {
                        dp[i][j+arr[i]] = 1;
                    }
                    int ab = Math.abs(j - arr[i]);
                    dp[i][ab] = 1;
                }
            }
        }
        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (q != 0) {
            int weight = Integer.parseInt(st.nextToken());

            boolean check = false;
            for(int i=1 ; i<=n ; i++) {
                if(dp[i][weight] != 0)
                    check = true;
            }

            if(check)
                System.out.print("Y ");
            else
                System.out.print("N ");
            q--;
        }
    }
}
