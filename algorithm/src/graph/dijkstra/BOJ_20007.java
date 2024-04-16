package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20007 {
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for(int i=0 ; i<n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, len));
            list[end].add(new Node(start, len));
        }
        visited = new boolean[n];
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[y] = 0;
        dijkstra(y);
        for(int i=0 ; i<n ; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("-1");
                return;
            }
        }
        Arrays.sort(dist);
        int result = 1;
        int sum = 0;
        for(int i=0 ; i<dist.length ; i++) {
            if(dist[i] * 2 > x) {
                System.out.println("-1");
                return;
            }

            sum += dist[i] * 2;
            if(sum > x) {
                result++;
                sum = dist[i] * 2;
            }
        }
        System.out.println(result);
    }
    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(visited[temp.vertex])
                continue;

            visited[temp.vertex] = true;
            for(Node next : list[temp.vertex]) {
                if(!visited[next.vertex]) {
                    if(dist[next.vertex] > dist[temp.vertex] + next.length) {
                        dist[next.vertex] = dist[temp.vertex] + next.length;
                        queue.add(new Node(next.vertex, dist[next.vertex]));
                    }
                }
            }
        }
    }
    static class Node implements Comparable<Node> {
        int vertex;
        int length;

        public Node(int vertex, int length) {
            this.vertex = vertex;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}
