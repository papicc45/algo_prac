package search.bfs;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1189 {
    static int r, c, k;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        for(int i=0 ; i<r ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<c ; j++) {
                map[i][j] = arr[j];
            }
        }

        visited[r-1][0] = true;
        dfs(r-1, 0, 1);
        System.out.println(result);

    }
    private static void dfs(int x, int y, int len) {
        if(len == k) {
            if(x == 0 && y== c-1)
                result++;

            return;
        }

        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<r && ny<c) {
                if(!visited[nx][ny] && map[nx][ny] != 'T') {
                    visited[nx][ny] = true;
                    dfs(nx, ny, len + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
