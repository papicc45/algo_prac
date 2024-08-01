package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16202 {
    static int n, m, k;
    static int[] parent;
    static int[][] nodeList;
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        parent = new int[n+1];

        for(int i=1 ; i<=m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end, i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<k ; i++) {
            if(i >= 1)
                list.remove(0);
            for(int j=1 ; j<=n ; j++)
                parent[j] = j;

            int cnt = 0;
            int result = 0;
            for(Node node : list) {
                if(find(node.start) != find(node.end)) {
                    union(node.start, node.end);
                    result += node.len;
                    cnt++;
                }
            }

            if(cnt == n-1)
                sb.append(result + " ");
            else {
                for(int j=i ; j<k ; j++) {
                    sb.append("0 ");
                }
                break;
            }
        }
        System.out.println(sb.toString());
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
