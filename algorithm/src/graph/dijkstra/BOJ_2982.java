package graph.dijkstra;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2982 {
    static final int INF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 정점 수
        int m = Integer.parseInt(st.nextToken());   // 간선 수

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        int[] route = new int[g];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < g; i++) route[i] = Integer.parseInt(st.nextToken());

        int[][] edgeLen = new int[n + 1][n + 1];           // 0 이면 간선 없음/미정
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
            if (edgeLen[u][v] == 0 || edgeLen[u][v] > w) { // 중복 간선 → 최소 길이만
                edgeLen[u][v] = edgeLen[v][u] = w;
            }
        }

        int[][] blkStart = new int[n + 1][n + 1];
        int[][] blkEnd   = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) Arrays.fill(blkStart[i], -1);     // -1 = 차단 없음

        int t = 0;
        for (int i = 0; i < g - 1; i++) {
            int u = route[i], v = route[i + 1];
            int len = edgeLen[u][v];          // 반드시 존재
            blkStart[u][v] = blkStart[v][u] = t;
            blkEnd[u][v]   = blkEnd[v][u]   = t + len;   // [ t, t+len ) 동안 점유
            t += len;
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = k;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, k));

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            if (cur.v == e) break;           // 최단 경로 확정
            visited[cur.v] = true;

            for (Node nxt : graph[cur.v]) {
                int cand = dist[cur.v];

                int bs = blkStart[cur.v][nxt.v];
                if (bs != -1) {
                    int be = blkEnd[cur.v][nxt.v];
                    if (cand >= bs && cand < be) {
                        cand = be;
                    }
                }
                cand += nxt.len;

                if (cand < dist[nxt.v]) {
                    dist[nxt.v] = cand;
                    pq.add(new Node(nxt.v, cand));
                }
            }
        }

        System.out.println(dist[e] - k);
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
