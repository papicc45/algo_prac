package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1277 {
    static Node[] nodes;
    static ArrayList<Edge>[] edges;
    static int n;
    static double m;
    static boolean[][] alreadyEdges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        m = Double.parseDouble(br.readLine());

        nodes = new Node[n+1];
        edges = new ArrayList[n+1];
        alreadyEdges = new boolean[n+1][n+1];
        for(int i=0 ; i<=n ; i++)
            edges[i] = new ArrayList<>();

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(x, y);
        }

        for(int i=0 ; i<w ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            alreadyEdges[start][end] = alreadyEdges[end][start] = true;
        }

        getLength();

        System.out.println((long)Math.floor(dijkstra() * 1000));

    }
    private static double dijkstra() {
        double answer = 0.0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0.0));

        while (!queue.isEmpty()) {
            Edge temp = queue.poll();

            if(temp.vertex == n) {
                answer = temp.len;
                break;
            }

            if(visited[temp.vertex]) continue;
            visited[temp.vertex] = true;

            for(Edge next : edges[temp.vertex]) {
                if(!visited[next.vertex]) {
                    if(alreadyEdges[temp.vertex][next.vertex]) {
                        queue.add(new Edge(next.vertex, temp.len));
                    } else {
                        queue.add(new Edge(next.vertex, temp.len + next.len));
                    }
                }
            }
        }
        return answer;
    }
    private static void getLength() {
        for(int i=1 ; i<=n ; i++) {
            Node start = nodes[i];
            for(int j=1 ; j<=n ; j++) {
                if(i == j) continue;
                Node end = nodes[j];

                long d1 = Math.abs(start.x - end.x);
                long d2 = Math.abs(start.y - end.y);
                double len = Math.sqrt(d1 * d1 + d2 * d2);
                if(len <= m) {
                    edges[i].add(new Edge(j, len));
                }

            }
        }
    }
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge> {
        int vertex;
        double len;

        public Edge(int vertex, double len) {
            this.vertex = vertex;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.len, o.len);
        }
    }
}
