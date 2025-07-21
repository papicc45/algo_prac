package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1799 {
    static int[][] arr;
    static int n;
    static boolean[] d1, d2;
    static ArrayList<int[]> blacks = new ArrayList<>();
    static ArrayList<int[]> whites = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    if((i + j) % 2 == 0) blacks.add(new int[]{i, j});
                    else whites.add(new int[]{i, j});
                }
            }
        }

        d1 = new boolean[n * 2];
        d2 = new boolean[n * 2];

        int b = dfs(blacks, 0);
        d1 = new boolean[n * 2];
        d2 = new boolean[n * 2];

        System.out.println(b + dfs(whites, 0));
    }
    private static int dfs(List<int[]> list, int idx) {
        if(idx == list.size()) return 0;

        int[] temp = list.get(idx);
        int tx = temp[0], ty = temp[1];

        int diag1 = tx + ty;
        int diag2 = tx - ty + (n - 1);

        int best = dfs(list, idx + 1);
        if(!d1[diag1] && !d2[diag2]) {
            d1[diag1] = true;
            d2[diag2] = true;
            best = Math.max(best, 1 + dfs(list, idx + 1));
            d1[diag1] = false;
            d2[diag2] = false;
        }

        return best;
    }
}
