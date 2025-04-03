package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12834 {
    static int n, v, e;
    static ArrayList<Node>[] list;
    static int KIST, CRFood;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        for(int i=0 ; i<=v ; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        KIST = Integer.parseInt(st.nextToken());
        CRFood =Integer.parseInt(st.nextToken());

        int[] team = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            team[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, len));
            list[b].add(new Node(a, len));
        }

        int result = 0;
        for(int i=0 ; i<n ; i++) {
            result += dijkstra(team[i]);
        }

        System.out.println(result);
    }
    private static int dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[v+1];
        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(visited[temp.v]) continue;
            visited[temp.v] = true;

            for(Node next : list[temp.v]) {
                if(!visited[next.v] && dist[next.v] > dist[temp.v] + next.len) {
                    dist[next.v] = dist[temp.v] + next.len;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        int sum = 0;
        sum += dist[KIST] != Integer.MAX_VALUE ? dist[KIST] : -1;
        sum += dist[CRFood] != Integer.MAX_VALUE ? dist[CRFood] : -1;

        return sum;
    }
    static class Node implements Comparable<Node> {
        int v;
        int len;

        public Node(int v, int len) {
            this.v = v;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            return this.len - o.len;
        }
    }
}
