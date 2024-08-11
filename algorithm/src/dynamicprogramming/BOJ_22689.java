package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] dp = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = true;
        for(int i=1 ; i<n ; i++) {
            for(int j=0 ; j<i ; j++) {
                if(dp[j]) {
                    int h = (i - j) * (1 + Math.abs(arr[j] - arr[i]));
                    if(h <= k) {
                        dp[i] = true;
                    }
                }
            }
        }

        if(dp[n-1])
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
