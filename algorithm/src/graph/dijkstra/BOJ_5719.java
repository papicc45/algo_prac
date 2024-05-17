package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.util.*;

public class BOJ_5719 {
    static int n, m;
    static int[] dist;
    static int s, e;
    static int result;
    static List<Integer>[] parent;
    static int[][] list;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0)
                break;
            parent = new List[n];
            check = new boolean[n][n];
            list = new int[n][n];
            for(int i=0 ; i<n ; i++) {
                parent[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            for(int i=0 ; i<m ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                list[start][end] = len;
                check[start][end] = true;
            }
            dijkstra();
            recur(s, e);
            System.out.println(dijkstra());
        }
    }
    private static void recur(int start, int goal) {
        if(start == goal)
            return;

        for(int next : parent[goal]) {
            if(check[next][goal]) {
                check[next][goal] = false;
                recur(start, next);
            }
        }
    }
    private static int dijkstra() {
        dist = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int i=0 ; i<n ; i++) {
                if(check[temp][i] && dist[i] == dist[temp] + list[temp][i]) {
                    parent[i].add(temp);
                } else if(check[temp][i] && dist[i] > dist[temp] + list[temp][i]) {
                    dist[i] = dist[temp] + list[temp][i];
                    queue.add(i);
                    parent[i].clear();
                    parent[i].add(temp);
                }
            }
        }

        if(dist[e] == Integer.MAX_VALUE / 2)
            return -1;
        else
            return dist[e];
    }
}
