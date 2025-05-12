package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16432 {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[][] dp;
    static int[][] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new boolean[n+1][10];
        parent = new int[n+1][10];
        list = new ArrayList[n+1];

        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for(int j=0 ; j<c ; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int x : list[1]) {
            dp[1][x] = true;
            parent[1][x] = -1;
        }

        for(int i=2 ; i<=n ; i++) {
            for(int x : list[i]) {
                for(int y : list[i-1]) {
                    if(y != x && dp[i-1][y]) {
                        dp[i][x] = true;
                        parent[i][x] = y;
                        break;
                    }
                }
            }
        }

        int last = -1;
        for(int x : list[n]) {
            if(dp[n][x]) {
                last = x;
                break;
            }
        }

        if(last == -1) {
            System.out.println("-1");
            return;
        }
        int cur = last;
        int[] result = new int[n+1];
        for(int day = n ; day >= 1 ; day--) {
            result[day] = cur;
            cur = parent[day][cur];
        }

        for(int i=1 ; i<=n ; i++) {
            System.out.println(result[i]);
        }
    }
}
