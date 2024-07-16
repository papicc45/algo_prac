package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2887 {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;

        Planet[] planets = new Planet[n];

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i + 1, x, y, z);
        }

        Arrays.sort(planets, (p1, p2) -> p1.x - p2.x);
        for(int i=0 ; i<n-1 ; i++) {
            int diff = Math.abs(planets[i].x - planets[i+1].x);
            queue.add(new Edge(planets[i].idx, planets[i+1].idx, diff));
        }

        Arrays.sort(planets, (p1, p2) -> p1.y - p2.y);
        for(int i=0 ; i<n-1 ; i++) {
            int diff = Math.abs(planets[i].y - planets[i+1].y);
            queue.add(new Edge(planets[i].idx, planets[i+1].idx, diff));
        }

        Arrays.sort(planets, (p1, p2) -> p1.z - p2.z);
        for(int i=0 ; i<n-1 ; i++) {
            int diff = Math.abs(planets[i].z - planets[i+1].z);
            queue.add(new Edge(planets[i].idx, planets[i+1].idx, diff));
        }

        long result = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            if(cnt == n-1)
                break;
            Edge edge = queue.poll();

            if(find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                cnt++;
                result += edge.len;
            }
        }
        System.out.println(result);
    }
    static class Planet {
        int idx;
        int x;
        int y;
        int z;
        public Planet(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int len;

        public Edge(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }
    private static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }
}
