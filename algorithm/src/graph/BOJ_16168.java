package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16168 {
    static int v, e;
    static ArrayList<Integer>[] list;
    static int[][] routes;
    static String result = "NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        routes = new int[v+1][v+1];
        list = new ArrayList[v+1];
        for(int i=0 ; i<=v ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        for(int i=1 ; i<=v ; i++) {
            dfs(i, i, 0);
        }

        System.out.println(result);
    }
    private static void dfs(int now, int n, int cnt) {
        if(cnt == e) {
            result = "YES";
            return;
        }

        for(Integer next : list[now]) {
            if(routes[now][next] == n || routes[next][now] == n)
                continue;

            routes[now][next] = routes[next][now] = n;
            dfs(next, n, cnt + 1);
        }
    }
}
