package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922 {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;

        PriorityQueue<Connect> queue = new PriorityQueue<>();
        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            queue.offer(new Connect(start, end, len));
        }

        int count = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Connect temp = queue.poll();

            if(find(temp.start) != find(temp.end)) {
                union(temp.start, temp.end);
                result += temp.len;
                count++;
            }

            if(count == n-1)
                break;
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
    static class Connect implements Comparable<Connect> {
        int start;
        int end;
        int len;

        public Connect(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Connect o) {
            return this.len - o.len;
        }
    }
}
