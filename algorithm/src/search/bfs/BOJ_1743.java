package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] visited;
    static int n, m, k;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    result = Math.max(result, bfs(i, j));
                }
            }
        }
        System.out.println(result);
    }
    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        int count = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
