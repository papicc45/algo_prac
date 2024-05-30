package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][n];
        int num = 2;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    disjoint(i, j, num);
                    num++;
                }
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] != 0) {
                    makeBridge(i, j);
                }
            }
        }
        System.out.println(result);
    }
    private static void makeBridge(int x, int y) {
        visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, temp[2] + 1});
                    }

                    if(map[nx][ny] != 0 && map[nx][ny] != map[x][y]) {
                        result = Math.min(result, temp[2]);
                    }
                }
            }
        }

    }
    private static void disjoint(int x, int y, int num) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        map[x][y] = num;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny] && map[nx][ny] != 0) {
                        map[nx][ny] = num;
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
