package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    static int n, s;
    static int[] arr;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        recur(0, 0, 0);
        System.out.println(result);
    }
    private static void recur(int idx, int sum, int depth) {
        if(depth != 0 && sum == s) {
            result++;
        }

        for(int i=idx ; i<n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recur(i, sum + arr[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}

