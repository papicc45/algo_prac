package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_28360 {
    static int n, m;
    static ArrayList<Integer>[] list;
    static double[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new double[n+1];

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        dp[1] = 100.0;
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for(int i=1 ; i<=n ; i++) {
            if(list[i].size() == 0) continue;

            for(int j=0 ; j<list[i].size() ; j++) {
                int next = list[i].get(j);

                dp[next] += (dp[i] / list[i].size());
            }
            dp[i] = 0.0;
        }
        double result = 0.0;
        for(int i=1 ; i<=n ; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);

    }
}
