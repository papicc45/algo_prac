package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17831 {
    static int n;
    static int[][] dp;
    static ArrayList<Integer>[] list;
    static int[] power;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2];
        power = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=2 ; i<=n ; i++) {
            list[Integer.parseInt(st.nextToken())].add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);
    }
    private static int dfs(int temp, int check) {
        if(dp[temp][check] != -1) {
            return dp[temp][check];
        }

        dp[temp][check] = 0;
        if(check == 0) {
            int sum = 0;
            int max = 0;
            for(int next : list[temp])
                sum += dfs(next, 0);

            for(int next : list[temp])
                max = Math.max(max, power[temp] * power[next] - dfs(next, 0) + dfs(next, 1));

            dp[temp][check] = Math.max(dp[temp][check], sum + max);
        } else {
            for(int next : list[temp])
                dp[next][check] += dfs(next, 0);
        }

        return dp[temp][check];
    }
}
