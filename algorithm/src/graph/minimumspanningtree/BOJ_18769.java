package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18769 {
    static int[] parent;
    static int n;
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=0 ; tc<t ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            n = r*c;

            parent = new int[n+1];
            for(int i=1 ; i<=n ; i++)
                parent[i] = i;

            PriorityQueue<Node> queue = new PriorityQueue<>();
            int j = 1;
            for(int i=1 ; i<=r ; i++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int len = Integer.parseInt(st.nextToken());
                    queue.add(new Node(j, j+1, len));
                    j++;
                }
                j++;
            }
            j = 1;
            for(int i=1 ; i<r ; i++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int len = Integer.parseInt(st.nextToken());
                    queue.add(new Node(j, j+c, len));
                    j++;
                }
            }

            int cnt = 0;
            int result = 0;
            while (!queue.isEmpty()) {
                if(cnt == n-1)
                    break;

                Node temp = queue.poll();

                if(find(temp.start) != find(temp.end)) {
                    union(temp.start, temp.end);
                    result += temp.len;
                    cnt++;
                }
            }

            System.out.println(result);
        }

    }
    static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
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
