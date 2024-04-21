package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1368 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] self = new int[n];
        for(int i=0 ; i<n ; i++) {
            self[i] = Integer.parseInt(br.readLine());
        }
        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;

        PriorityQueue<Link> queue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0 ; j<n ; j++) {
                if(i == j) {
                    queue.add(new Link(0, i+1, self[i]));
                } else if(i < j) {
                    queue.add(new Link(i+1, j+1, Integer.parseInt(arr[j])));
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            Link temp = queue.poll();

            if(find(temp.start) != find(temp.end)) {
                union(temp.start, temp.end);
                result += temp.len;
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
        if(a != b) {
            parent[b] = a;
        }
    }
    static class Link implements Comparable<Link> {
        int start;
        int end;
        int len;

        public Link(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Link o) {
            return this.len - o.len;
        }
    }
}
