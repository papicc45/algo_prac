package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9344 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n, m, p, q;
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            boolean[] build = new boolean[m];
            int[][] pq = new int[m][2];
            for(int i=1 ; i<=n ; i++)
                parent[i] = i;

            PriorityQueue<Edge> queue = new PriorityQueue<>();
            for(int i=0 ; i<m ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());
                pq[i][0] = start;
                pq[i][1] = end;
                queue.add(new Edge(start, end, len, i));
            }

            int cnt = 0;
            while (cnt != n-1) {
                Edge e = queue.poll();

                if(find(e.start) != find(e.end)) {
                    union(e.start, e.end);
                    cnt++;
                    build[e.idx] = true;
                }
            }

            boolean result = false;
            for(int i=0 ; i<m ; i++) {
                if(build[i] && p == pq[i][0] && q == pq[i][1]) {
                    result = true;
                    break;
                }
            }

            System.out.println(result ? "YES" : "NO");
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

        if(a != b) {
            parent[b] = a;
        }
    }
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int len;
        int idx;

        public Edge(int start, int end, int len, int idx) {
            this.start = start;
            this.end = end;
            this.len = len;
            this.idx = idx;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }
}
