package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_2665 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j=0 ; j<n ; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }
    private static int bfs() {
        int answer = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int cnt = temp[2];

            if(tx == n - 1 && ty == n - 1) {
                answer = cnt;
                break;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if(map[nx][ny] == 0) {
                    queue.add(new int[] {nx, ny, cnt + 1});
                } else {
                    queue.add(new int[] {nx, ny, cnt});
                }
            }
        }
        return answer;
    }
}
