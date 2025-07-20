package search.dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
                if((i + j) % 2 == 0) blacks.add(new int[]{i, j});
                else whites.add(new int[]{i, j});
            }
        }

        d1 = new boolean[n * 2];
        d2 = new boolean[n * 2];
    }
}
