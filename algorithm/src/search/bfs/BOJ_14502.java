package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][] visited;
    static int[][] map;

    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(answer);
    }
    private static void DFS(int wall) {
        if(wall == 3) {
            BFS();
            return;
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    private static void BFS() {
        visited = new boolean[n][m];

        int[][] copy = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                copy[i][j] = map[i][j];
                if(map[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(!visited[nx][ny] && copy[nx][ny] == 0) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        copy[nx][ny] = 2;
                    }
                }
            }
        }

        int count = 0;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(copy[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
}
