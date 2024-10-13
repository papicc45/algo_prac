package search.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1113 {
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    static int result = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];
        for(int i=1; i<N+1; i++) {
            map[i][0] = 0;
            map[i][M+1] = 0;
            String s = br.readLine();
            for(int j=1; j<M+1; j++) {
                map[i][j] = s.charAt(j-1)-'0';
            }
        }
        for(int i=0; i<M+2; i++) {
            map[0][i] = 0;
            map[N+1][i] = 0;
        }
        for(int k=1 ; k<=9 ; k++) {
            for(int i=1 ; i<N+1 ; i++) {
                for(int j=1 ; j<M+1 ; j++) {
                    if(map[i][j] == k && !visited[i][j]) {
                        bfs(i, j, k);
                    }
                }
            }
        }
        System.out.println(result);
    }
    private static void bfs(int x, int y, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        ArrayList<int[]> list = new ArrayList<>();
        int min = 9;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            list.add(new int[] {tx, ty});

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (map[nx][ny] == 0) {
                    min = 0;
                } else {
                    if(map[nx][ny] != height) {
                        min = Math.min(min, map[nx][ny]);
                        continue;
                    }

                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        if(min > height) {
            int diff = min - height;
            for(int[] node : list) {
                map[node[0]][node[1]] = min;
                visited[node[0]][node[1]] = false;
                result += diff;
            }
        }
    }
}
