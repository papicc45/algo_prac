package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1949 {
    static ArrayList<Integer>[] list;
    static int[][] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list =  new ArrayList[n+1];
        dp = new int[n+1][2];
        arr = new int[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();
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

        for(int i=1 ; i<=n ; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(Math.max(dfs(1, -1, 1) + arr[1], dfs(1, -1, 0)));
    }
    private static int dfs(int temp, int before, int flag) {
        if(dp[temp][flag] != -1) return dp[temp][flag];

        dp[temp][flag] = 0;
        for(int next : list[temp]) {
            if(next == before) continue;

            if(flag == 1) {
                dp[temp][flag] += dfs(next, temp, 0);
            } else {
                dp[temp][flag] += Math.max(dfs(next, temp, 1) + arr[next], dfs(next, temp, 0));
            }
        }

        return dp[temp][flag];
    }
}
