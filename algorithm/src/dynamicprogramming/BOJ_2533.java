package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2533 {
    static int n;
    static int[][] dp;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1][2];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    private static void dfs(int parent) {
        visited[parent] = true;
        dp[parent][0] = 0;
        dp[parent][1] = 1;

        for(int child : list[parent]) {
            if(!visited[child]) {
                dfs(child);
                dp[parent][0] += dp[child][1];
                dp[parent][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
