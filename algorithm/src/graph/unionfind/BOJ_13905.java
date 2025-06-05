package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13905 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Bridge(start, end, weight));
        }

        int result = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            if(find(s) == find(e))
                break;
            Bridge b = pq.poll();

            if(find(b.start) != find(b.end)) {
                union(b.start, b.end);
                result = Math.min(result, b.weight);
            }
        }

        if(find(s) == find(e)) {
            System.out.println(result);
        } else {
            System.out.println(0);
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
    static class Bridge implements Comparable<Bridge> {
        int start;
        int end;
        int weight;

        public Bridge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.weight - this.weight;
        }
    }
}
