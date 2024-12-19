package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23352 {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int result = 0;
    static int length = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(arr[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];
        queue.add(new int[] {x, y, 1});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0], ty = temp[1];
            int len = temp[2];

            if(len != 1 && len > length) {
                length = len;
                result = arr[x][y] + arr[tx][ty];
            } else if(len != 1 && len == length) {
                if(result < arr[x][y] + arr[tx][ty]) {
                    result = arr[x][y] + arr[tx][ty];
                }
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny, len + 1});
            }
        }

    }
}
