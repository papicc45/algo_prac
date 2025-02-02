package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1486 {
    static int[][] map;
    static int n, m, t, d;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<m ; j++) {
                if(arr[j] >= 'A' && arr[j] <= 'Z') {
                    map[i][j] = arr[j] - 'A';
                } else {
                    map[i][j] = arr[j] - 'A' - 6;
                }
            }
        }

        dijkstra();

    }
    private static void dijkstra() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        boolean[][][] visited = new boolean[n][m][d+1];
        queue.add(new int[] {map[0][0], 0, 0, 0, 0});

        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int th = cur[0];
            int tt = cur[1];
            int tx = cur[2];
            int ty = cur[3];
            int tmax = cur[4];

            if(tx == 0 && ty == 0 && tt != 0) {
                max = Math.max(max, tmax);
            }

            if(visited[tx][ty][tt]) continue;
            visited[tx][ty][tt] = true;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                int nt = 0;
                if(map[nx][ny] > map[tx][ty]) {
                    if(map[nx][ny] - map[tx][ty] <= t) {
                        int diff = (int)Math.pow(map[tx][ty] - map[nx][ny], 2);
                        nt = tt + diff;
                    }
                } else {
                    nt = tt + 1;
                }
                if(nt == 0 || nt > d) continue;
                if(visited[nx][ny][nt]) continue;


                queue.add(new int[] {map[nx][ny], nt, nx, ny, Math.max(map[nx][ny], map[tx][ty])});
            }
        }

        System.out.println(max);
    }
}
