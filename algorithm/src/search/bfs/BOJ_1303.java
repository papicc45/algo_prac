package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
    static char[][] map;
    static int n, m;
    static boolean[][] visited;
    static int bs = 0, ws = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1 ,1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        visited = new boolean[m][n];

        for(int i=0 ; i<m ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<n ; j++) {
                map[i][j] = arr[j];
            }
        }

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(ws + " " + bs);
    }
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] {x, y});
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0], ty = temp[1];
            cnt++;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx <0 || ny <0 || nx >= m || ny >= n) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != map[x][y]) continue;
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
            }
        }

        int add = (int)Math.pow(cnt, 2);
        if( map[x][y] == 'W') {
            ws += add;
        } else {
            bs += add;
        }
    }
}
