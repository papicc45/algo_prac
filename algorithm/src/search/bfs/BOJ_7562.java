package search.bfs;

import java.beans.beancontext.BeanContextServiceProviderBeanInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    static int n;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int sx, sy;
    static int gx, gy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=0 ; tc<t ; tc++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());

            System.out.println(bfs());
        }
    }
    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sx, sy, 0});
        boolean[][] visited = new boolean[n][n];
        visited[sx][sy] = true;
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];

            if(tx == gx && ty == gy) {
                answer = temp[2];
                break;
            }

            for(int i=0 ; i<8 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, temp[2] + 1});
                }
            }
        }
        return answer;
    }
}
