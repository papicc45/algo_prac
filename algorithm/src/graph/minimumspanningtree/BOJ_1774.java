package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1774 {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            parent[i] = i;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[] {x, y});
        }

        PriorityQueue<Passage> queue = new PriorityQueue<>();
        for(int i=0 ; i<list.size() ; i++) {
            int[] arr1 = list.get(i);
            int x1 = arr1[0];
            int y1 = arr1[1];
            for(int j=i+1 ; j<list.size() ; j++) {
                int[] arr2 = list.get(j);
                int x2 = arr2[0];
                int y2 = arr2[1];
                double len = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
                queue.add(new Passage(i+1, j+1, len));
            }
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start, end);
        }

        double result = 0.0;
        int count = 0;
        while (!queue.isEmpty()) {
            Passage temp = queue.poll();

            if(find(temp.start) != find(temp.end)) {
                union(temp.start, temp.end);
                result += temp.len;
                count++;
            }
            if(count == n-1)
                break;
        }
        System.out.println(String.format("%.2f", result));
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
    static class Passage implements Comparable<Passage> {
        int start;
        int end;
        double len;

        public Passage(int start, int end, double len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Passage o) {
            return Double.compare(this.len, o.len);
        }
    }
}
