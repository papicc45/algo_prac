package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4781{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double m = Double.parseDouble(st.nextToken());

            if(n == 0 && m == 0.00)
                break;

            int mm = (int)(m * 100 + 0.5);
            int[] cal = new int[n];
            int[] money = new int[n];
            for(int i=0 ; i<n ; i++) {
                st = new StringTokenizer(br.readLine());
                cal[i] = Integer.parseInt(st.nextToken());
                money[i] = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
            }
            long result = 0;
            int[] dp = new int[mm+1];
            for(int i=0 ; i<=mm ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(i - money[j] >= 0) {
                        dp[i] = Math.max(dp[i], dp[i-money[j]] + cal[j]);
                        result = Math.max(result, dp[i]);
                    }
                }
            }
            System.out.println(result);
        }
    }
}
