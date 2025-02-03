package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.BaseStream;

public class BOJ_14699 {
    static int[] dp;
    static int[] h;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n+1];
        h = new int[n+1];
        list = new ArrayList[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
            h[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, h[i]);
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        Arrays.fill(dp, -1);
        for(int i=1 ; i<=n ; i++) {
            System.out.println(recur(i, h[i]));
        }

    }
    private static int recur(int idx, int height) {
        if(list[idx].isEmpty() || height == max)
            return 1;

        if(dp[idx] != -1)
            return dp[idx];

        int s = 1;
        for(int next : list[idx]) {
            if(height < h[next]) {
                s = Math.max(s, recur(next, h[next]) + 1);
            }
        }
        dp[idx] = s;
        return s;
    }
}
