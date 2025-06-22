package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1240 {
    static int n, m;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,len));
            list[b].add(new Node(a, len));
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(bfs(a, b));
        }
    }
    private static int bfs(int start, int end) {
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        int answer = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.vertex == end) {
                answer = cur.len;
                break;
            }

            for(Node next : list[cur.vertex]) {
                if(!visited[next.vertex]) {
                    visited[next.vertex] = true;
                    queue.add(new Node(next.vertex, cur.len + next.len));
                }
            }
        }
        return answer;
    }
    static class Node {
        int vertex;
        int len;

        public Node(int v, int len) {
            vertex = v;
            this.len = len;
        }
    }
}
