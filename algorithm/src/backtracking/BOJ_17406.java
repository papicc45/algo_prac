package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
    static int n, m, k;
    static int[][] cal;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        cal = new int[k][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<3 ; j++) {
                cal[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[k];
        recur(map, 0);
        System.out.println(result);
    }
    private static int getMinValue(int[][] map) {
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++) {
            int sum = 0;
            for(int j=0 ; j<m ; j++) {
                sum += map[i][j];
            }

            min = Math.min(sum, min);
        }

        return min;
    }
    private static int[][] rotateArr(int[][] map, int r, int c, int s) {
        int top = r - s, left = c - s, bottom = r + s, right = c + s;
        while (top < bottom && left < right) {
            int prev = map[top][left];
            // 윗변
            for (int j = left + 1; j <= right; j++) {
                int tmp = map[top][j];
                map[top][j] = prev;
                prev = tmp;
            }
            // 오른변
            for (int i = top + 1; i <= bottom; i++) {
                int tmp = map[i][right];
                map[i][right] = prev;
                prev = tmp;
            }
            // 아랫변
            for (int j = right - 1; j >= left; j--) {
                int tmp = map[bottom][j];
                map[bottom][j] = prev;
                prev = tmp;
            }
            // 왼변
            for (int i = bottom - 1; i >= top; i--) {
                int tmp = map[i][left];
                map[i][left] = prev;
                prev = tmp;
            }
            top++; left++; bottom--; right--;
        }
        return map;
    }
    private static void recur(int[][] map, int depth) {
        if(depth == k) {
            result = Math.min(result, getMinValue(map));
            return;
        }

        for(int i=0 ; i<k ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int[][] newMap = copyMap(map);
                newMap = rotateArr(newMap, cal[i][0] - 1, cal[i][1] - 1, cal[i][2]);
                recur(newMap, depth + 1);
                visited[i] = false;
            }
        }
    }
    private static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, m);
        }

        return newMap;
    }
}
