package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27210 {
    static int n;
    static int[] dp;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //왼쪽
        for(int i=1 ; i<=n ; i++) {
            int pos = arr[i] == 1 ? 1 : -1;
            dp[i] = Math.max(dp[i-1] + pos, pos);
        }
        check();
        dp = new int[n+1];

        //오른쪽
        for(int i=1 ; i<=n ; i++) {
            int pos = arr[i] == 2 ? 1 : -1;
            dp[i] = Math.max(dp[i-1] + pos, pos);
        }
        check();

        System.out.println(result);

    }
    private static void check() {
        for(int i=1 ; i<=n ; i++) {
            result = Math.max(result, dp[i]);
        }
    }
}
