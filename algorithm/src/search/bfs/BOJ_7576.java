package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int m, n;
    static int[] dx = {0, 0, -1 , 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
//        result = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0 ; i<n ; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1) {
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
                    if(!visited[nx][ny] && map[nx][ny] != -1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }

                result = Math.max(map[i][j], result);
            }
        }
        System.out.println(result-1);

    }
}
