package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17090 {
    static int n, m;
    static char[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = arr[j];
            }
        }

        long result = 0;
        for(int i=0 ; i < n; i++) {
            for(int j=0 ; j < m ; j++) {
                result += recur(i, j);
            }
        }

        System.out.println(result);
    }
    private static int recur(int x, int y) {
        if(x == n || y == m || x == -1 || y == -1) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        int nx = x, ny = y;
        if(map[x][y] == 'U') {
            nx -= 1;
        } else if(map[x][y] == 'R') {
            ny += 1;
        } else if(map[x][y] == 'D') {
            nx += 1;
        } else if(map[x][y] == 'L') {
            ny -= 1;
        }

        dp[x][y] += recur(nx, ny);

        return dp[x][y];
    }
}
