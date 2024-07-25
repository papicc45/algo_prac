package graph.minimumspanningtree;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21924 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;

        long sum = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, len));
            sum += len;
        }

        int cnt = 0;
        long cost = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(find(temp.start) != find(temp.end)) {
                union(temp.start, temp.end);
                cnt++;
                cost += temp.len;
            }
        }
        if(cnt != n-1)
            System.out.println(-1);
        else
            System.out.println(sum - cost);

    }
    private static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b= find(b);

        if(a != b)
            parent[b] = a;
    }
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int len;

        public Node(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            return this.len - o.len;
        }
    }
}
