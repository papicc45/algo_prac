package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_22358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n+1][k+1];

        ArrayList<int[]>list = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            dp[end][0] =Math.max(dp[end][0], dp[start][0] + len);
            list.add(new int[] {start, end, len});
        }
        for(int i=1 ; i<=k ; i++) {
            for(int j=0 ; j<list.size() ; j++) {
                int start = list.get(j)[0];
                int end = list.get(j)[1];
                int len = list.get(j)[2];

                dp[end][i] = dp[end][i-1] * 2;
            }
        }
    }
}
