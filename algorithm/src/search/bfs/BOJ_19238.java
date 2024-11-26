package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19238 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, k;
    static int[][] map;
    static int sx, sy;
    static Goal[][] goals;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        goals = new Goal[n+1][n+1];
        map = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            int gx = Integer.parseInt(st.nextToken());
            int gy = Integer.parseInt(st.nextToken());

            goals[cx][cy] = new Goal(gx, gy);
        }
        solution();
        System.out.println(k);
    }
    private static void solution() {

        while (true) {
            if(m == 0)
                break;
            //가장 가까운 손님 찾기
            int[] arr = searchClient();
            if(arr[2] == Integer.MAX_VALUE) {
                k = -1;
                break;
            }
            k -= arr[2];
            if(k  < 0) {
                k = -1;
                break;
            } else {
                int ex = goals[arr[0]][arr[1]].x;
                int ey = goals[arr[0]][arr[1]].y;
                int range = bfs(arr[0], arr[1], ex, ey);
                goals[arr[0]][arr[1]] = null;
                if(range == 0) {
                    k = -1;
                    break;
                }
                if(k - range >= 0) {
                    k -= range;
                    k += (range * 2);
                    sx = ex;
                    sy = ey;
                    m--;
                } else {
                    k = -1;
                    break;
                }
            }

        }
    }
    private static boolean check(int x, int y) {
        if(x<=0 || y<=0 || x>n || y>n) return false;
        if(visited[x][y]) return false;
        if(map[x][y] == 1) return false;

        return true;
    }
    private static int bfs(int x, int y, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        visited = new boolean[n+1][n+1];
        visited[x][y] = true;
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0], ty = temp[1];
            int tk = temp[2];

            if(tx == ex && ty == ey) {
                answer = tk;
                break;
            }
            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(check(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, tk + 1});
                }
            }
        }

        return answer;
    }
    private static int[] searchClient() {
        int[] arr = new int[3];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});
        visited = new boolean[n+1][n+1];
        visited[sx][sy] = true;
        int gas = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int tk = temp[2];

            if(goals[tx][ty] != null) {
                if(gas > tk) {
                    arr[0] = tx;
                    arr[1] = ty;
                    gas = tk;
                } else if(gas == tk) {
                    if(arr[0] > tx) {
                        arr[0] = tx;
                        arr[1] = ty;
                        gas = tk;
                    } else if(arr[0] == tx) {
                        if(arr[1] > ty) {
                            arr[0] = tx;
                            arr[1] = ty;
                            gas = tk;
                        }
                    }
                }
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(check(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, tk + 1});
                }
            }
        }
        arr[2] = gas;
        return arr;
    }
    static class Goal {
        int x;
        int y;

        public Goal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
