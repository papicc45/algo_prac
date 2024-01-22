package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2056_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        int result = 0;
        for(int i=1 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int preCount = Integer.parseInt(st.nextToken());

            dp[i] = time;
            for(int j=0 ; j<preCount ; j++) {
                int next = Integer.parseInt(st.nextToken());

                dp[i] = Math.max(dp[i], dp[next] + time);
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
