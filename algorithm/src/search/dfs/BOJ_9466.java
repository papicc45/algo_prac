package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;

public class BOJ_9466 {
    static int n;
    static int[] arr;
    static int result;
    static boolean[] visited, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k=0 ; k<t ; k++) {
            n = Integer.parseInt(br.readLine());
            result = 0;

            arr = new int[n+1];
            visited = new boolean[n+1];
            check = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1 ; i<=n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1 ; i<=n ; i++) {
                if(!check[i])
                    recur(i);
            }
            System.out.println(n - result);
        }
    }
    private static void recur(int num) {
        if(check[num])
            return;

        if(visited[num]) {
            check[num] = true;
            result++;
        }

        visited[num] = true;
        recur(arr[num]);
        check[num] = true;
        visited[num] = false;
    }
}
