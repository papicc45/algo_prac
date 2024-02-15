package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i=0 ; i<n ; i++) {
            String[] str = br.readLine().split("");
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(BFS());
    }
    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int len = temp[2];
            int wallBreak = temp[3];

            if(tx == n-1 && ty == m-1)
                return len;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                if(map[nx][ny] == 0) {
                    if(!visited[nx][ny][wallBreak]) {
                        visited[nx][ny][wallBreak] = true;
                        queue.add(new int[] {nx, ny, len + 1, wallBreak});
                    }
                }else {
                    if(wallBreak == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new int[] {nx, ny, len + 1, 1});
                    }
                }
            }
        }
        return -1;
    }
}
