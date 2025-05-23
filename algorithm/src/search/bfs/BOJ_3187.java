package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static int n, m;
    static int vcnt, kcnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i=0 ; i<n ; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<m ; j++){
                map[i][j] = arr[j];
                if(map[i][j] == 'k') {
                    kcnt++;
                } else if(map[i][j] == 'v') {
                    vcnt++;
                }
            }
        }

        visited = new boolean[n][m];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(!visited[i][j]) {
                    if(map[i][j] == 'k' || map[i][j] == 'v') {
                        bfs(i, j);
                    }
                }
            }
        }

        System.out.println(kcnt + " " + vcnt);
    }
    private static void bfs(int x, int y) {
        int v = 0, k = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;


        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int tx = temp[0], ty = temp[1];

            if(map[tx][ty] == 'k') k++;
            else if(map[tx][ty] == 'v') v++;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == '#') continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        if(k > v) {
            vcnt -= v;
        } else {
            kcnt -= k;
        }
    }
}
