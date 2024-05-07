package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1726 {
    static int[] move = {1, 2, 3};
    static int n, m;
    static int[][] map;
    //1 - 동, 2 - 서, 3 - 남, 4 - 북
    static boolean[][][] visited;
    static int sx, sy, ex, ey;
    static int sd, ed;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        sd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey= Integer.parseInt(st.nextToken());
        ed = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
    private static int bfs() {
        int answer = 0;
        visited = new boolean[n+1][m+1][5];
        //1 - 동, 2 - 서, 3 - 남, 4 - 북

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, sd, 0});
        visited[sx][sy][sd] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int td = temp[2];
            int count = temp[3];

            if (tx == ex && ty == ey && td == ed) {
                answer = count;
                break;
            }

            if (td == 1 || td == 2) {
                if (!visited[tx][ty][3]) {
                    visited[tx][ty][3] = true;
                    queue.add(new int[]{tx, ty, 3, count + 1});
                }
                if (!visited[tx][ty][4]) {
                    visited[tx][ty][4] = true;
                    queue.add(new int[]{tx, ty, 4, count + 1});
                }
                if (td == 1) {
                    for (int i = 0; i < 3; i++) {
                        int ny = ty + move[i];

                        if (ny >= 1 && ny <= m) {
                            if(map[tx][ny] == 1) break;
                            if(visited[tx][ny][td]) continue;

                            visited[tx][ny][td] = true;
                            queue.add(new int[]{tx, ny, td, count + 1});
                        }
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        int ny = ty - move[i];

                        if (ny >= 1 && ny <= m) {
                            if(map[tx][ny] == 1) break;
                            if(visited[tx][ny][td]) continue;

                            visited[tx][ny][td] = true;
                            queue.add(new int[]{tx, ny, td, count + 1});
                        }
                    }
                }
            } else {
                if (!visited[tx][ty][1]) {
                    visited[tx][ty][1] = true;
                    queue.add(new int[]{tx, ty, 1, count + 1});
                }
                if (!visited[tx][ty][2]) {
                    visited[tx][ty][2] = true;
                    queue.add(new int[]{tx, ty, 2, count + 1});
                }
                if (td == 3) {
                    for (int i = 0; i < 3; i++) {
                        int nx = tx + move[i];

                        if (nx >= 1 && nx <= n) {
                            if(map[nx][ty] == 1) break;
                            if(visited[nx][ty][td]) continue;

                            visited[nx][ty][td] = true;
                            queue.add(new int[]{nx, ty, td, count + 1});
                        }
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        int nx = tx - move[i];

                        if (nx >= 1 && nx <= n) {
                            if(map[nx][ty] == 1) break;
                            if(visited[nx][ty][td]) continue;

                            visited[nx][ty][td] = true;
                            queue.add(new int[]{nx, ty, td, count + 1});
                        }
                    }
                }
            }
        }
        return answer;
    }
}
