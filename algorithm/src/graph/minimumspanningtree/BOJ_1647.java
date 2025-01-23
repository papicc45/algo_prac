package graph.minimumspanningtree;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, len));
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (cnt != n-1) {
            Node node = queue.poll();

            if(find(node.start) != find(node.end)) {
                union(node.start, node.end);
                sum += node.len;
                max = Math.max(max, node.len);
                cnt++;
            }
        }

        System.out.println(sum - max);
    }
    private static int find(int a) {
        if(a == parent[a]) {
            return  a;
        }
        return parent[a] = find(parent[a]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

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
