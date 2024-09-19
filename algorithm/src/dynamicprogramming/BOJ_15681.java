package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15681 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        visited = new boolean[n+1];
        dp = new int[n+1];
        dfs(r);

        for(int i=0 ; i<q ; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
    private static int dfs(int idx) {
        if(visited[idx]) return dp[idx];

        visited[idx] = true;
        dp[idx] = 1;
        for(int next : list[idx]) {
            if(!visited[next]) {
                dp[idx] += dfs(next);
            }
        }

        return dp[idx];
    }
}
