package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21606 {
    static ArrayList<Integer>[] list;
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        String[] str = br.readLine().split("");
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(str[i - 1]);

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);

            if (arr[start] == 1 && arr[end] == 1)
                result += 2;
        }


        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            if (arr[i] == 0 && !visited[i]) {
                visited[i] = true;
                cnt += dfs(i);
            }
            result += cnt * (cnt - 1);
        }
        System.out.println(result);
    }

    private static int dfs(int idx) {
        int cnt = 0;
        for(int next : list[idx]) {
            if(!visited[next] && arr[next] == 0) {
                visited[next] = true;
                cnt += dfs(next);
            }

            if(arr[next] == 1)
                cnt++;
        }
        return cnt;
    }
}
