package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int direct = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(sx, sy, direct);
        System.out.println(result);

    }
    private static void bfs(int sx, int sy, int direct) {
        int clean = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];
        queue.add(new int[] {sx, sy, direct});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty =temp[1];
            int td = temp[2];
            if(map[tx][ty] == 0) {
                clean++;
                map[tx][ty] = 2;
            }

            boolean check = false;
            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(range(nx, ny) && map[nx][ny] == 0) {
                    check = true;
                    break;
                }
            }
            // 1 - 동, 3 - 서, 2 - 남, 0 - 북
            if(check) {
                int nd = td == 0 ? 3 : td - 1;
                int[] co = moveDirect(tx, ty, nd);
                int nx = co[0];
                int ny = co[1];

                if(range(nx, ny) && map[nx][ny] == 0) {
                    queue.add(new int[] {nx, ny, nd});
                    visited[nx][ny] = true;
                } else {
                    queue.add(new int[] {tx, ty, nd});
                }
            } else {
                int nx, ny;
                if(td == 1) {
                    nx = tx;
                    ny = ty - 1;
                } else if(td == 2) {
                    nx = tx - 1;
                    ny = ty;
                } else if(td == 3) {
                    nx = tx;
                    ny = ty + 1;
                } else {
                    nx = tx + 1;
                    ny = ty;
                }
                if(map[nx][ny] != 1) {
                    queue.add(new int[] {nx, ny, td});
                } else {
                    break;
                }
            }
        }
        result = clean;
    }
    private static int[] moveDirect(int x, int y, int direct) {
        int[] co = new int[2];
        if(direct == 1) {
            co[0] = x;
            co[1] = y + 1;
        } else if(direct == 2) {
            co[0] = x + 1;
            co[1] = y;
        } else if(direct == 3) {
            co[0] = x;
            co[1] = y - 1;
        } else {
            co[0] = x - 1;
            co[1] = y;
        }
        return co;
    }
    private static boolean range(int x, int y) {
        if(x>=0 && y>=0 && x<n && y<m)
            return true;

        return false;
    }
}
