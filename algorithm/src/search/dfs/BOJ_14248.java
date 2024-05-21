package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14248 {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());
        recur(k-1);
        int result = 0;
        for(int i=0 ; i<n ; i++) {
            if(visited[i])
                result++;
        }
        System.out.println(result);
    }
    private static void recur(int index) {
        visited[index] = true;

        int left = index - arr[index];
        int right = index + arr[index];

        if(left>=0 && left<n && !visited[left]) {
            recur(left);
        }

        if(right>=0 && right<n && !visited[right]) {
            recur(right);
        }
    }
}
