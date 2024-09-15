package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2186 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static String goal;
    static int[][][] dp;
    static int n, m, k;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i=0 ; i<n ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<m ; j++) {
                map[i][j] = arr[j];
            }
        }
        goal = br.readLine();
        dp = new int[n][m][goal.length()];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] == goal.charAt(0))
                    result += dfs(i, j, 0);
            }
        }
        System.out.println(result);
    }
    private static int dfs(int x, int y, int cnt) {
        if(dp[x][y][cnt] != -1) return dp[x][y][cnt];
        if(cnt == goal.length() -1) {
            dp[x][y][cnt] = 1;
            return dp[x][y][cnt];
        }

        dp[x][y][cnt] = 0;

        for(int i=0 ; i<4 ; i++) {
            for(int j=1 ; j<=k ; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(map[nx][ny] == goal.charAt(cnt+1)) dp[x][y][cnt] += dfs(nx ,ny, cnt+1);
            }
        }

        return dp[x][y][cnt];
    }
}
