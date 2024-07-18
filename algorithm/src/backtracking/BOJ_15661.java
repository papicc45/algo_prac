package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661 {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int check = 0;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            visited = new boolean[n];
            check = i+1;
            recur(0, 0);
        }
        System.out.println(result);


    }
    private static void recur(int idx, int cnt) {
        if(cnt == check) {
            int a = 0;
            int b = 0;

            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(i == j)
                        continue;

                    if(visited[i] && visited[j]) {
                        a += arr[i][j];
                    }
                    if(!visited[i] && !visited[j]) {
                        b += arr[i][j];
                    }
                }
            }
            result = Math.min(result, Math.abs(a - b));
            return;
        }

        for(int i=idx ; i<n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recur(i + 1, cnt + 1);
                visited[i] = false;
            }
        }

    }
}
