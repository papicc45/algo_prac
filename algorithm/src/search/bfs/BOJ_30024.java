package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_30024 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+2][m+2];

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        k = Integer.parseInt(br.readLine());
        bfs();
    }
    private static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        boolean[][] visited = new boolean[n+2][m+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || i == n || j == 1 || j == m) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        queue.add(new int[] {map[i][j], i, j});
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {

            int[] temp = queue.poll();
            int val = temp[0];
            int x = temp[1];
            int y = temp[2];
            if (1 <= x && x <= n && 1 <= y && y <= m) {
                sb.append(x).append(" ").append(y).append("\n");
                k--;
                if (k == 0) break;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || ny<0 || nx>=n+2 || ny>=m+2) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.add(new int[] {map[nx][ny], nx, ny});
            }
        }
        System.out.println(sb.toString());
    }
}
