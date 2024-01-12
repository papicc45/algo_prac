package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long[][] dp = new long[31][31];

            for(int i=0 ; i<=30 ; i++) {
                dp[i][1] = i;
                dp[i][0] = 1;
                dp[i][i] = 1;
            }

            for(int i=2 ; i<=30 ; i++) {
                for(int j=1 ; j<i ; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(dp[m][n]);
            t--;
        }
    }
}
