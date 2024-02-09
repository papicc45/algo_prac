package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NoSuchObjectException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while (true) {
            int icbergs = icebergCount();

            if(icbergs >= 2)
                break;
            else if(icbergs == 0) {
                time = 0;
                break;
            }

            BFS();
            time++;
        }
        System.out.println(time);
    }
    private static int icebergCount() {
        visited = new boolean[n][m];

        int count = 0;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    DFS(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void DFS(int x, int y) {
        visited[x][y] = true;
        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<m) {
                if(!visited[nx][ny] && map[nx][ny] > 0) {
                    DFS(nx, ny);
                }
            }
        }
    }
    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] > 0) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];

            int count = 0;
            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(!visited[nx][ny] && map[nx][ny] == 0)
                        count++;
                }
            }
            if(map[tx][ty] - count < 0)
                map[tx][ty] = 0;
            else
                map[tx][ty] -= count;
        }
    }
}
