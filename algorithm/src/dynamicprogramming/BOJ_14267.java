package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14267 {
    static int n, m;
    static long[] dp;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new long[n + 1];
        list = new ArrayList[n+1];
        for(int i=0; i<=n ; i++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            int superior = Integer.parseInt(st.nextToken());
            if(superior == -1)
                continue;

            list[superior].add(i);
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dp[num] += w;
        }
        dfs(1);
        for(int i=1 ; i<=n ; i++)
            System.out.print(dp[i] + " ");
    }
    private static void dfs(int num) {

        for(int load : list[num]) {
            dp[load] += dp[num];
            dfs(load);
        }
    }
}
