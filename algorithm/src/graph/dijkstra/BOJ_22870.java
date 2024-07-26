package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22870 {
    static int n, m;
    static boolean[] visited;
    static ArrayList<Node>[] list;
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

        visited = new boolean[n+1];
        System.out.println(dijkstra(start, end) + dijkstra(end, start));
    }
    private static long dijkstra(int start, int end) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        long answer = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.goal == end) {
                answer = temp.len;
                break;
            }

            if(visited[temp.goal]) continue;

            visited[temp.goal] = true;
            for(Node next : list[temp.goal]) {
                if(!visited[next.goal]) {
                    if(dist[next.goal] > dist[temp.goal] + next.len) {
                        dist[next.goal] = dist[temp.goal] + next.len;
                        visited[next.goal] = true;
                        queue.add(new Node(next.goal, dist[next.goal]));
                    }
                }
            }
        }
        return answer;
    }
    static class Node implements Comparable<Node> {
        int goal;
        long len;

        public Node(int goal, long len) {
            this.goal = goal;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            if(this.len == o.len) {
                return this.goal - o.goal;
            } else {
                return (int)(this.len - o.len);
            }
        }
    }
}
