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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        boolean[] dp = new boolean[40001];
        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[arr[i]] = true;
        }

        int sum = arr[0];
        for(int i=1 ; i<n ; i++) {
            sum += arr[i];
            dp[sum] = true;
        }

    }
}
