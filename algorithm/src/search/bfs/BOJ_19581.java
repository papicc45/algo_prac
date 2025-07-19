package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19581 {
    static int n;
    static ArrayList<Node>[] list;
    static boolean[] visited;
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
            int len = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, len));
            list[end].add(new Node(start, len));
        }

        Node n1 = bfs(1, 0);
        Node n2 = bfs(n1.vertex, 0);

        Node n3 = bfs(n1.vertex, n2.vertex);
        Node n4 = bfs(n2.vertex, n1.vertex);

        System.out.println(Math.max(n3.len, n4.len));
    }
    private static Node bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[n+1];
        queue.add(new Node(start, 0));
        visited[start] = true;

        Node answer = new Node(start, 0);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.vertex != end && temp.len > answer.len) {
                answer.vertex = temp.vertex;
                answer.len = temp.len;
            }

            for(Node next : list[temp.vertex]) {
                if(!visited[next.vertex]) {
                    visited[next.vertex] = true;
                    queue.add(new Node(next.vertex, temp.len + next.len));
                }
            }
        }
        return answer;
    }
    static class Node {
        int vertex;
        int len;

        public Node(int vertex, int len) {
            this.vertex = vertex;
            this.len = len;
        }
    }
}
