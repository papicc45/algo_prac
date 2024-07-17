package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21937 {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int result = 0;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();



        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

        x = Integer.parseInt(br.readLine());
        bfs(x);

        System.out.println(result);
    }
    private static void bfs(int num) {
        visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int next : list[temp]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }

        result = cnt;

    }
}
