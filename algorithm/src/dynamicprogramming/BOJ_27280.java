package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27280 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] h = new long[n];
        long[] s = new long[n];

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            h[i] = Long.parseLong(st.nextToken());
            s[i] = Long.parseLong(st.nextToken());
        }

        long[][] max = new long[n][n];
        for(int i=0 ; i<n ; i++) {
            long mh = 0;
            long sum = 0;
            for(int j=i ; j<n ; j++) {
                if(h[j] > mh) {
                    mh = h[j];
                    sum = s[j];
                } else if(h[j] == mh) {
                    sum += s[j];
                }
                max[i][j] = sum;
            }
        }

        long[][] dp = new long[m+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            dp[1][i] = max[0][i-1];
        }

        for(int i=2 ; i<=m ; i++) {
            for(int j=i ; j<=n ; j++) {
                long maxVal = 0;

                for(int k= i-1 ; k<j ; k++) {
                    long ss = dp[i-1][k] + max[k][j-1];
                    if(ss > maxVal) {
                        maxVal = ss;
                    }
                }
                dp[i][j] = maxVal;
            }
        }

        System.out.println(dp[m][n]);
    }
}
