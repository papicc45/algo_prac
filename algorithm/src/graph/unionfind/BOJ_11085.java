package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11085 {
    static int p, w;
    static int c, v;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        parent = new int[p];
        for(int i=0 ; i<p ; i++)
            parent[i] = i;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i=0 ; i<w ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, width));
        }

        int result = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            result = node.width;

            if(find(node.start) != find(node.end))
                union(node.start, node.end);

            if(find(c) == find(v)) {
                break;
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
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int width;

        public Node(int start, int end, int width) {
            this.start = start;
            this.end = end;
            this.width = width;
        }

        @Override
        public int compareTo(Node o) {
            return o.width - this.width;
        }
    }
}
