package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1520 {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] dp;

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for(int i=0 ; i<n ; i++)
            Arrays.fill(dp[i], -1);

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 0));
    }
    private static int dfs(int x, int y) {
        if(x == n-1 && y == m-1)
            return 1;

        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;
        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(map[x][y] > map[nx][ny]) {
                        dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}
