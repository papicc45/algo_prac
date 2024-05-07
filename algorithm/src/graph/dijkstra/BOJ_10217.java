package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10217 {
    static int n, m, k;
    static ArrayList<Airport>[] list;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0 ; tc<t ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            for(int i=0 ; i<=n ; i++)
                list[i] = new ArrayList<>();

            for(int i=0 ; i<k ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                list[start].add(new Airport(end, cost, time));
            }
        }
        dp = new int[n+1][m+1];
        for(int i=0 ; i<=n ; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);

        dp[1][0] = 0;
        for(int i=0 ; i<=m ; i++) {
            for(int j=1 ; j<=n ; j++) {
                for(Airport airport : list[j]) {
                    if(i + airport.cost <= m) {
                        dp[airport.goal][i + airport.cost] = Math.min(dp[airport.goal][i + airport.cost], dp[j][i] + airport.time);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE / 2;
        for(int i=0 ; i<=m ; i++) {
            result = Math.min(result, dp[n][i]);
        }
        StringBuilder sb = new StringBuilder();
        if(result == Integer.MAX_VALUE / 2)
            sb.append("Poor KCM");
        else
            sb.append(result);

        System.out.println(sb.toString());
    }
    static class Airport  {
        int goal;
        int cost;
        int time;

        public Airport(int goal, int cost, int time) {
            this.goal = goal;
            this.cost = cost;
            this.time = time;
        }

    }
}
