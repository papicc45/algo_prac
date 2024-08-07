package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14284 {
    static int n, m;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;
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
            int value = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, value));
            list[end].add(new Node(start, value));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(s, t));
    }
    private static int dijkstra(int s, int t) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[s] = 0;
        int answer = 0;
        queue.add(new Node(s, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.vertex == t) {
                answer = dist[temp.vertex];
                break;
            }

            if(visited[temp.vertex]) continue;
            visited[temp.vertex] = true;

            for(Node next : list[temp.vertex]) {
                if(dist[next.vertex] > dist[temp.vertex] + next.value) {
                    dist[next.vertex] = dist[temp.vertex] + next.value;
                    queue.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return answer;
    }
    static class Node implements Comparable<Node> {
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
