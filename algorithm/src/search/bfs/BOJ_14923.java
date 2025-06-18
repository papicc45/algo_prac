package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14923 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int hx = Integer.parseInt(st.nextToken()) - 1;
        int hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(hx, hy, ex, ey));
    }
    private static int bfs(int hx, int hy, int ex, int ey) {
        boolean[][][] visited = new boolean[n][m][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {hx, hy, 0, 0});
        visited[hx][hy][0] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tx = temp[0], ty = temp[1];
            int time = temp[2];
            int b = temp[3];

            if(tx == ex && ty == ey) {
                return time;
            }
            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                if(map[nx][ny] == 1) {
                    if(!visited[nx][ny][1] && b == 0) {
                        visited[nx][ny][1] = true;
                        q.add(new int[] {nx, ny, time+1, 1});
                    }
                } else {
                    if(!visited[nx][ny][b]) {
                        visited[nx][ny][b] = true;
                        q.add(new int[] {nx, ny, time+1, b});
                    }
                }
            }
        }

        return -1;
    }
}
