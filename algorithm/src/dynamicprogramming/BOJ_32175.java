package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_32175 {
    static int n, h;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        dp = new int[h+1];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -1);
        System.out.println(recur(0));
    }
    private static int recur(int height) {
        if(height == h)
            return 1;

        if(dp[height] != -1)
            return dp[height];

        int cnt = 0;
        for(int i=0 ; i<n ; i++) {
            if(height + arr[i] <= h) {
                cnt += recur(height + arr[i]) % 1000000007;
                cnt %= 1000000007;
            }
        }
        dp[height] = cnt;

        return dp[height];
    }
}
