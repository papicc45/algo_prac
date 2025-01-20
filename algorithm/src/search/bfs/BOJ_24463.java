package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24463 {
    static char[][] map;
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int sx = 0, sy = 0, ex = 0, ey = 0;
    static int[][] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        cnt = new int[n][m];

        for(int i=0 ; i<n ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<m ; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == '+') {
                    cnt[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if (sx == 0 && sy == 0) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }
        bfs();
        changeMap(ex, ey);
        map[sx][sy] = '!';
        StringBuilder sb = new StringBuilder();
        map[sx][sy] = '!';
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] == '.') {
                    sb.append("@");
                } else if(map[i][j] == '!') {
                    sb.append(".");
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[sx][sy] = true;
        queue.add(new int[] {sx, sy});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0], ty = temp[1];

            if(tx == ex && ty == ey) {
                break;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(!check(nx, ny)) continue;
                if(map[nx][ny] == '+') continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
                cnt[nx][ny] = cnt[tx][ty] + 1;
            }
        }
    }
    private static boolean check(int x, int y) {
        if(x<0 ||  y<0 || x>=n || y>=m) return false;
        return true;
    }
    private static void changeMap(int x, int y) {
        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!check(nx, ny)) continue;
            if(cnt[x][y] - 1 == cnt[nx][ny]) {
                map[x][y] = '!';
                changeMap(nx, ny);
            }
        }
    }
}
