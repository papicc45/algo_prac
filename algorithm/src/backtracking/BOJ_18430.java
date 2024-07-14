package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.DuplicateFormatFlagsException;
import java.util.StringTokenizer;

public class BOJ_18430 {
    static int n, m;
    static int[][] woods;
    static boolean[][] visited;
    static int result = Integer.MIN_VALUE;
    static int[][] d= {{1, 0, 0, 1}, {1, 0, 0, -1}, {0, -1, -1, 0},{-1, 0, 0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        0, 0 -> (1, 0 0, 1) (1, 0 0, -1) (0, -1 -1, 0) (-1, 0 0 1)
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        woods = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                woods[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
        System.out.println(result);
    }
    private static boolean range(int x, int y) {
        if(x>=0 && y>=0 && x<n && y<m) {
            return true;
        }

        return false;
    }
    private static void recur(int idx, int sum) {
        if(idx == n*m) {
            result = Math.max(result, sum);
            return;
        }
        int tx = idx / m;
        int ty = idx % m;

        for(int k=0 ; k<4 ; k++) {
            int x1 = tx + d[k][0];
            int y1 = ty + d[k][1];
            int x2 = tx + d[k][2];
            int y2 = ty + d[k][3];
            if(!range(x1, y1)) continue;
            if(!range(x2, y2)) continue;
            if(visited[tx][ty] || visited[x1][y1] || visited[x2][y2]) continue;

            visited[tx][ty] = true;
            visited[x1][y1] = true;
            visited[x2][y2] = true;
            int add = (woods[tx][ty] * 2) + woods[x1][y1] + woods[x2][y2];
            recur(idx + 1,sum + add);
            visited[tx][ty] = false;
            visited[x1][y1] = false;
            visited[x2][y2] = false;
        }
        recur(idx + 1, sum);
    }
}
