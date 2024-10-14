package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10836 {
    static int[][] arr;
    static boolean[][] visited;
    static int[][] grow;
    static int m, n;
    static int[] dx = {0, -1, -1};
    static int[] dy = {-1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][m];
        grow = new int[n][3];

        for(int i=0 ; i<m ; i++)
            Arrays.fill(arr[i], 1);

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<3 ; j++) {
                grow[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t=0 ; t<n ; t++) {
            firstGrow(t);
        }
        remainGrow();

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<m ; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void firstGrow(int day) {
        int x = m-1;
        int y = 0;
        int add = 0;
        while (true) {
            if(x == 0 && y == m)
                break;

            int[] grows = grow[day];
            for(int i=0 ; i<grows[add] ; i++) {
                arr[x][y] += add;

                if(x == 0) y++;
                else x--;
            }
            add++;
        }
    }
    private static void remainGrow() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[m][m];
        visited[1][1] = true;
        queue.add(new int[] {1, 1});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int tx = temp[0], ty = temp[1];
            for(int i=0 ; i<3 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                arr[tx][ty] = Math.max(arr[tx][ty], arr[nx][ny]);
            }

            int rightX = tx;
            int rightY = ty + 1;
            int downX = tx + 1;
            int downY = ty;

            if(check(rightX, rightY)) {
                queue.add(new int[] {rightX, rightY});
                visited[rightX][rightY] = true;
            }

            if(check(downX, downY)) {
                queue.add(new int[] {downX, downY});
                visited[downX][downY] = true;
            }
        }
    }
    private static boolean check(int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= m) return false;
        if(visited[x][y]) return false;

        return true;
    }
}
