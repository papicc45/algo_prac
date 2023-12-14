package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dx = {2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1};
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        int result = 0;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            result++;

            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx >=0 && ny >=0 && nx<n && ny <m && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(result);
    }
}
