package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13911 {
    static int n;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;
    static int x, y;

    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, len));
            list[end].add(new Node(start, len));
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] macDist = new int[n+1];
        Arrays.fill(macDist, Integer.MAX_VALUE);
        for(int i=0 ; i<m ; i++) {
            int mc = Integer.parseInt(st.nextToken());
            macDist[mc] = 0;
            queue.add(new Node(mc, 0));
        }
        dijkstra(macDist);
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int[] starDist = new int[n+1];
        Arrays.fill(starDist, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<s ; i++) {
            int star = Integer.parseInt(st.nextToken());
            starDist[star] = 0;
            queue.add(new Node(star, 0));
        }
        dijkstra(starDist);
        int result = Integer.MAX_VALUE;
        for(int i=1 ; i<=n ; i++) {
            if(macDist[i] > 0 && macDist[i] <= x && starDist[i] > 0 && starDist[i] <= y)
                result = Math.min(result, macDist[i] + starDist[i]);
        }

        if(result != Integer.MAX_VALUE)
            System.out.println(result);
        else
            System.out.println("-1");

    }
    private static void dijkstra(int[] arr) {

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            for(Node next : list[temp.vertex]) {
                if(arr[next.vertex] > arr[temp.vertex] + next.length) {
                    arr[next.vertex] = arr[temp.vertex] + next.length;
                    queue.add(new Node(next.vertex, arr[next.vertex]));
                }
            }
        }
    }
    static class Node implements Comparable<Node> {
        int vertex;
        int length;

        public Node(int vertex, int length) {
            this.vertex = vertex;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}
