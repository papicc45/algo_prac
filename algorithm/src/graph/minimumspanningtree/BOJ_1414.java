package graph.minimumspanningtree;

import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1414 {
    static int n;
    static int sum;
    static int[] arr;
    static PriorityQueue<Edge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] charArr = st.nextToken().toCharArray();
            int temp = 0;
            for(int j=0 ; j<n ; j++) {
                if(charArr[j] >= 'a' && charArr[j] <= 'z')
                    temp = charArr[j] - 'a' + 1;
                else if(charArr[j] >= 'A' && charArr[j] <= 'Z')
                    temp = charArr[j] - 'A' + 27;

                sum += temp;
                if(i != j && temp != 0)
                    queue.add(new Edge(i, j, temp));
            }
        }
        arr = new int[n];
        for(int i=0 ; i<arr.length ; i++)
            arr[i] = i;

        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Edge temp = queue.poll();
            if(find(temp.start) != find(temp.end)) {
                union(temp.start, temp.end);
                result += temp.len;
                useEdge++;
            }
        }
        if(useEdge == n-1)
            System.out.println(sum - result);
        else
            System.out.println("-1");
    }
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int len;

        Edge(int start ,int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }
    private static int find(int a) {
        if(arr[a] == a)
            return a;

        return arr[a] = find(arr[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            arr[b] = a;
    }
}
