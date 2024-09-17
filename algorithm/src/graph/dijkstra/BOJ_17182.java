package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17182 {
    static int n;
    static boolean[] visited;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                int len = Integer.parseInt(st.nextToken());
                arr[i][j] = len;
            }
        }

        for(int t=0 ; t<n ; t++) {
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(i == j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][t] + arr[t][j]);
                }
            }
        }

        visited[k] = true;
        dfs(k, 0, 0);
        System.out.println(result);
    }
    private static void dfs(int start, int sum, int cnt) {
        if(cnt == n-1) {
            result = Math.min(result, sum);
            return;
        }

        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, sum + arr[start][i], cnt + 1);
                visited[i] = false;
            }
        }
    }
}
