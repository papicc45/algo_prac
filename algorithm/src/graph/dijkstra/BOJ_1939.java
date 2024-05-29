package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1939 {
    static ArrayList<Node>[] list;
    static int n, m;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, len));
            list[end].add(new Node(start, len));
        }

         st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);

    }
    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, Integer.MAX_VALUE));
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[start] = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(visited[temp.vertex])
                continue;

            visited[temp.vertex] = true;

            for(Node next : list[temp.vertex]) {
                int min = Math.min(temp.len, next.len);
                if(min > dist[next.vertex]) {
                    dist[next.vertex] = min;
                    queue.add(new Node(next.vertex, min));
                }
            }
        }
    }
    static class Node implements Comparable<Node> {
        int vertex;
        int len;

        public Node(int vertex, int len) {
            this.vertex = vertex;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            return o.len - this.len;
        }
    }
}
