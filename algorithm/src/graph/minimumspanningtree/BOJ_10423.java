package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10423 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        for(int i=1 ; i<k ; i++) {
            int num = Integer.parseInt(st.nextToken());
            union(first, num);
        }

        PriorityQueue<Cable> pq = new PriorityQueue<>();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Cable(a, b, cost));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            if(k == n)
                break;

            Cable c = pq.poll();

            if(find(c.a) != find(c.b)) {
                union(c.a, c.b);
                result += c.cost;
                k++;
            }
        }

        System.out.println(result);
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
    static class Cable implements Comparable<Cable> {
        int a;
        int b;
        int cost;

        Cable(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cable o) {
            return this.cost - o.cost;
        }
    }
}
