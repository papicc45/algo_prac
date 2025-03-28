package search.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21938 {
    static RGB[][] color;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        color = new RGB[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                color[i][j] = new RGB(r, g, b);
            }
        }

        int t = Integer.parseInt(br.readLine());
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int avg = (int)((color[i][j].r + color[i][j].g + color[i][j].b) / 3);
                if(avg >= t) {
                    arr[i][j] = 1;
                }
            }
        }

        int result = 0;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    result++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;

                queue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    static class RGB {
        int r, g, b;

        public RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
}
