package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16985 {

    static int[][][] origin = new int[5][5][5];
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int result = Integer.MAX_VALUE;
    static int[] order = new int[5];
    static boolean[] used = new boolean[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0 ; i<5 ; i++) {
            for(int j=0 ; j<5 ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0 ; k<5 ; k++) {
                    origin[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        recur(0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
    private static void recur(int depth) {
        if(depth == 5) {
            int[][][] board = new int[5][5][5];
            for(int i=0 ; i<5 ; i++) {
                int idx = order[i];
                for(int j=0 ; j<5 ; j++) {
                    System.arraycopy(origin[idx][j], 0, board[i][j], 0, 5);
                }
            }

            depthRotate(0, board);
            return;
        }

        for(int i=0 ; i<5 ; i++) {
            if(!used[i]) {
                used[i] = true;
                order[depth] = i;
                recur(depth + 1);
                used[i] = false;
            }
        }
    }
    private static int bfs(int[][][] arr) {

        if (arr[0][0][0] == 0 || arr[4][4][4] == 0)
            return Integer.MAX_VALUE;

        boolean[][][] visited = new boolean[5][5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int tx = temp[0];
            int ty = temp[1];
            int tz = temp[2];
            int tc = temp[3];

            if (tx == 4 && ty == 4 && tz == 4)
                return tc;

            for (int i = 0; i < 6; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                int nz = tz + dz[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) continue;
                if (visited[nx][ny][nz]) continue;
                if (arr[nx][ny][nz] == 0) continue;

                visited[nx][ny][nz] = true;
                queue.add(new int[]{nx, ny, nz, tc + 1});
            }
        }
        return Integer.MAX_VALUE;
    }
    private static void depthRotate(int depth, int[][][] board) {
        if(depth == 5) {
            result = Math.min(result, bfs(board));
            return;
        }

        int[][] origin = board[depth];
        for(int i=0 ; i<4 ; i++) {
            if(i > 0) {
                board[depth] = rotate(board[depth]);
            }
            depthRotate(depth + 1, board);
        }
        board[depth] = origin;
    }
    private static int[][] rotate(int[][] arr) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                ans[j][n-1-i] = arr[i][j];
            }
        }

        return ans;
    }
}
