package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2213 {
    static ArrayList<Integer>[] list;
    static int[][] dp;
    static boolean[] visited;
    static int[] arr;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        dp = new int[n+1][2];
        visited = new boolean[n+1];
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);

        if(dp[1][0] > dp[1][1]) {
            System.out.println(dp[1][0]);
            makeRoute(1, 0);
        } else {
            System.out.println(dp[1][1]);
            makeRoute(1, 1);
        }
        Collections.sort(result);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
    private static void makeRoute(int idx, int flag) {
        visited[idx] = true;

        if(flag == 1) {
            result.add(idx);
            for(int next : list[idx]) {
                if(!visited[next]) {
                    makeRoute(next, 0);
                }
            }
        } else {
            for(int next : list[idx]) {
                if(!visited[next]) {
                    if(dp[next][0] > dp[next][1]) {
                        makeRoute(next, 0);
                    } else {
                        makeRoute(next, 1);
                    }
                }
            }
        }
        visited[idx] = false;
    }
    private static void dfs(int idx) {


        dp[idx][0] = 0;
        dp[idx][1] = arr[idx];

        visited[idx] = true;

        for(int next : list[idx]) {
            if(visited[next]) continue;

            dfs(next);

            dp[idx][1] += dp[next][0];
            if(dp[next][0] > dp[next][1]) {
                dp[idx][0] += dp[next][0];
            } else {
                dp[idx][0] += dp[next][1];
            }
        }
        visited[idx] = false;
    }
}
