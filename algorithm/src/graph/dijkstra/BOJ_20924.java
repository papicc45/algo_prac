package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20924 {
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        int[] degree = new int[n+1];
        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, value));
            list[end].add(new Node(start, value));
        }

        int[] result = dijkstra(n, r);
        System.out.println(result[0] + " " + result[1]);

    }
    private static int[] dijkstra(int n, int r) {
        int[] answer = new int[2];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];

        queue.add(new Node(r, 0));
        int giga = 0;
        int len = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.vertex == r && list[temp.vertex].size() == 2) {
                giga = temp.vertex;
                answer[0] = temp.value;
                break;
            }
            if(list[temp.vertex].size()-1 >= 2) {
                giga = temp.vertex;
                answer[0] = temp.value;
                break;
            }
            if(visited[temp.vertex]) continue;
            visited[temp.vertex] = true;


            for(Node next : list[temp.vertex]) {
                if(!visited[next.vertex]) {
                    len += next.value;
                    queue.add(new Node(next.vertex, temp.value + next.value));
                }
            }
        }
        if(giga == 0) {
            giga = 1;
            answer[0] = len;
        }

        int[] dist = new int[n+1];
        queue = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[giga] = 0;
        queue.add(new Node(giga, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(visited[temp.vertex]) continue;
            visited[temp.vertex] = true;

            for(Node next : list[temp.vertex]) {
                if(!visited[next.vertex] && dist[next.vertex] < dist[temp.vertex] + next.value) {
                    dist[next.vertex] = dist[temp.vertex] + next.value;
                    queue.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++) {
            if(dist[i] != Integer.MIN_VALUE) {
                max = Math.max(max, dist[i]);
            }
        }

        answer[1] = max;
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
            return o.value - this.value;
        }
    }
}
