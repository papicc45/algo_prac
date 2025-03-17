package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;

public class BOJ_18809 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr;
    static int n, m, g, r;
    static int result = Integer.MIN_VALUE;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    list.add(new int[] {i, j});
                }
            }
        }

        int[] choose = new int[list.size()];

        dfs(0, 0, 0, choose);
        System.out.println(result);


    }
    private static void bfs(int[] choose) {
        int[][] visited = new int[n][m];
        int[][] time = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0 ; i<choose.length ; i++) {
            int color = choose[i];
            if(color != 0) {
                int[] arr = list.get(i);
                int x = arr[0];
                int y = arr[1];

                visited[x][y] = color;
                queue.add(new int[] {x, y, choose[i], 0});
            }
        }

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0], ty = temp[1];
            int color = temp[2];
            int tt = temp[3];

            if(visited[tx][ty] == 3) continue;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(arr[nx][ny] == 0) continue;
                if(visited[nx][ny] == 3) continue;

                if(visited[nx][ny] == 0) {
                    visited[nx][ny] = color;
                    time[nx][ny] = tt + 1;
                    queue.add(new int[] {nx ,ny, color, tt + 1});
                } else if(visited[nx][ny] == 1 && color == 2 && time[nx][ny] == tt + 1) {
                    visited[nx][ny] = 3;
                    cnt++;
                } else if(visited[nx][ny] == 2 && color == 1 && time[nx][ny] == tt + 1) {
                    visited[nx][ny] = 3;
                    cnt++;
                }
            }

            result = Math.max(result, cnt);
        }
    }
    private static void dfs(int index, int gc, int rc, int[] choose) {
        if(gc == g && rc == r) {
            bfs(choose);
            return;
        }

        if(index == list.size())
            return;

        if(gc < g) {
            choose[index] = 1;
            dfs(index + 1, gc + 1, rc, choose);
            choose[index] = 0;
        }

        if(rc < r) {
            choose[index] = 2;
            dfs(index + 1, gc, rc + 1, choose);
            choose[index] = 0;
        }

        dfs(index + 1, gc, rc, choose);
    }
}
