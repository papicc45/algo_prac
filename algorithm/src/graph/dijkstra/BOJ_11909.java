package graph.dijkstra;

import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11909 {
    static int[][] map;
    static int n;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dijkstra();
        System.out.println(dist[n-1][n-1]);
    }
    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0));
        dist = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int tx = temp.x;
            int ty = temp.y;

            for(int i=0 ; i<2 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int next = Math.max(map[nx][ny] - map[tx][ty] + 1, 0);

                if(dist[nx][ny] > dist[tx][ty] + next) {
                    dist[nx][ny] = dist[tx][ty] + next;
                    queue.add(new Node(nx, ny, dist[nx][ny]));
                }

            }
        }
    }
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
}
