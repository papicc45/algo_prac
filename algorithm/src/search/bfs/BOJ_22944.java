package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22944 {
    static char[][] map;
    static int N, H, D;
    static int sx, sy, ex, ey;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int K = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if(map[i][j] == 'E') {
                    ex = i;
                    ey = j;
                } else if(map[i][j] == 'U') {
                    K++;
                }
            }
        }
        System.out.println(bfs());
    }
    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][N][H+K*D];
        queue.add(new Node(sx, sy, H, 0, 0));
        visited[sx][sy][0] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.x == ex && temp.y == ey) {
                return temp.t;
            }

            if(temp.h == 0 && temp.d == 0) continue;

            for(int i=0 ; i<4 ; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(visited[nx][ny][temp.t]) continue;

                int nh = temp.d != 0 ? temp.h : temp.h -1;
                if(map[nx][ny] == 'U') {
                    queue.add(new Node(nx, ny, nh, D, temp.t + 1));
                } else {
                    int nd = temp.d != 0 ? temp.d - 1 : 0;
                    queue.add(new Node(nx, ny, nh, nd, temp.t + 1));
                }
                visited[nx][ny][temp.t+1] = true;
            }
        }
        return -1;
    }
    static class Node {
        int x;
        int y;
        int h;
        int d;
        int t;

        public Node(int x, int y, int h, int d, int t) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.d = d;
            this.t = t;

        }
    }
}
