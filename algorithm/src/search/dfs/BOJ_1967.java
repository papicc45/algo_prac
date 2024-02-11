package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {
    static ArrayList<Node>[] list;
    static int result = Integer.MIN_VALUE;
    static boolean[] visited;
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[e1].add(new Node(e2, val));
            list[e2].add(new Node(e1, val));
        }

        for(int i=1 ; i<=n ; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            DFS(i, 0);
        }
        System.out.println(result);
    }
    private static void DFS(int num, int value) {
        result = Math.max(result, value);

        for(Node next : list[num]) {
            if(!visited[next.vertex]) {
                visited[next.vertex] = true;
                DFS(next.vertex, value + next.value);
            }
        }
    }
    static class Node {
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}
