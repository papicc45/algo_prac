package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;

public class BOJ_16724 {
    static char[][] map;
    static int result = 0;
    static boolean[][] visited;
    static boolean[][] safe;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        safe = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[j];
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(result);
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int nx = x;
        int ny = y;

        if(map[x][y] == 'D') {
            nx++;
        } else if (map[x][y] == 'U') {
            nx--;
        } else if (map[x][y] == 'L') {
            ny--;
        } else {
            ny++;
        }

        if(!visited[nx][ny]) {
            dfs(nx, ny);
        }else {
            if(!safe[nx][ny])
                result++;
        }

        safe[x][y] = true;
    }
}
