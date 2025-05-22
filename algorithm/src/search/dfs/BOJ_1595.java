package search.dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1595 {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList[10001];
        for(int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<>();
        }

        while (true) {
            try {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, len));
                list[e].add(new Node(s, len));
            } catch (Exception e) {
                break;
            }
        }

        visited = new boolean[10001];
        visited[1] = true;
        dfs(0, 1);

        visited = new boolean[10001];
        visited[index] = true;
        dfs(0, index);

        System.out.println(result == Integer.MIN_VALUE ? 0 : result);
    }
    private static void dfs(int length, int idx) {

        for(Node next : list[idx]) {
            if(!visited[next.vertex]) {
                visited[next.vertex] = true;
                if(next.len + length > result) {
                    index = next.vertex;
                    result = next.len + length;
                }
                dfs(length + next.len, next.vertex);
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
