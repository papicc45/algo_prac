package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1595 {
    static ArrayList<Node>[] list;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList[10001];
        for(int i = 0; i < 10001; i++)
            list[i] = new ArrayList<>();

        while (true) {
            try {
                String str = br.readLine();

                StringTokenizer st = new StringTokenizer(str);
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end, len));
                list[end].add(new Node(start, len));

            } catch (Exception e) {
                break;
            }
        }

        for(int i=1 ; i<=10000 ; i++) {
            bfs(i);
        }
        System.out.println(result);
    }
    private static void bfs(int idx) {
        boolean[] visited = new boolean[10001];
        visited[idx] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(idx, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            result = Math.max(result, temp.len);
            for(Node next : list[temp.vertex]) {
                if(!visited[next.vertex]) {
                    visited[next.vertex] = true;
                    queue.add(new Node(next.vertex, temp.len + next.len));
                }
            }
        }
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
