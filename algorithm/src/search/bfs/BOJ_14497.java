package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14497 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    static int n, m;
    static int sx, sy;
    static int ex, ey;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        for(int i=1 ; i<=n ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=1 ; j<=m ; j++) {
                map[i][j] = arr[j-1];
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        boolean[][] visited = new boolean[n+1][m+1];
        queue.add(new int[] {sx, sy, 0});

        int answer = 0;
        while (!queue.isEmpty()) {

            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int jump = temp[2];

            if(tx == ex && ty == ey) {
                answer = jump;
                break;
            }

            if(visited[tx][ty]) continue;
            visited[tx][ty] = true;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<=0 || ny<=0 || nx>n || ny>m) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == '1' || map[nx][ny] == '#') {
                    queue.add(new int[] {nx, ny, jump + 1});
                } else {
                    queue.add(new int[] {nx, ny, jump});
                }
            }
        }
        return answer;
    }
}
