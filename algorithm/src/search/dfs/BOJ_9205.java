package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_9205 {
    static int n;
    static int[][] arr;
    static int ex, ey;
    static boolean check;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int k=0 ; k<t ; k++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n+2][2];


            for (int i=0 ; i<n+2 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            check = false;
            visited = new boolean[n];
            dfs(0, 0);
            if(check)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
    private static void dfs(int depth, int idx) {
        if(1000 >= Math.abs(arr[idx][0] - arr[n+1][0]) + Math.abs(arr[idx][1] - arr[n+1][1])) {
            check = true;
        }

        if(depth == n || check)
            return;

        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                if(1000 >= Math.abs(arr[idx][0] - arr[i+1][0]) + Math.abs(arr[idx][1] - arr[i+1][1])) {
                    visited[i] = true;
                    dfs(depth + 1, i + 1);
                }
            }
        }
    }
}
