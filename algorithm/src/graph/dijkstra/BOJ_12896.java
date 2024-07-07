package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12896 {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int max, mn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }
        max = Integer.MIN_VALUE;
        visited = new boolean[n+1];
        dfs(1, 0);

        max = Integer.MIN_VALUE;
        visited = new boolean[n+1];
        dfs(mn, 0);

        System.out.println((1 + max) / 2);

    }
    private static void dfs(int idx, int length) {
        if(max < length) {
            max = length;
            mn = idx;
        }

        visited[idx] = true;
        for(int next : list[idx]) {
            if(!visited[next]) {
                dfs(next, length + 1);
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
