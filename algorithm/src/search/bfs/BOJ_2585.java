package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2585 {
    static Node[] nodes;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nodes = new Node[n];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        }

        int left = 0;
        int right = cal(0, 0, 10000, 10000);

        while (left < right) {
            int mid = (left + right) / 2;

            if(bfs(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
    private static boolean bfs(int fuel) {
        boolean[] visited = new boolean[n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(cal(temp.x, temp.y, 10000, 10000) <= fuel) return true;
            if(temp.count == k) continue;

            for(int i=0 ; i<n ; i++) {
                if(!visited[i]) {
                    if(fuel >= cal(temp.x, temp.y, nodes[i].x, nodes[i].y)) {
                        visited[i] = true;
                        queue.add(new Node(nodes[i].x, nodes[i].y, temp.count + 1));
                    }
                }
            }
        }
        return false;
    }
    private static int cal(int sx, int sy, int ex, int ey) {
        double d = Math.sqrt(Math.pow(ex - sx, 2) + Math.pow(ey - sy, 2));
        if(d / 10 == (int)d / 10)
            return (int)d / 10;
        else
            return (int)d / 10 + 1;
    }
    static class Node {
        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
