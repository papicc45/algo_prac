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
    static int sx, sy;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
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
                }
            }
        }
        int answer = bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    private static int bfs() {
        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy, H, 0, 0));
        int[][] dist = new int[N][N];
        dist[sx][sy] = H;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();


            if(map[temp.x][temp.y] == 'E') {
                answer = Math.min(answer, temp.time);
                continue;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nu = temp.um;
                int nh = temp.hp;

                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(map[nx][ny] == 'E') {
                    answer = Math.min(answer, temp.time + 1);
                    continue;
                }

                if(map[nx][ny] == 'U') nu = D;
                if(nu != 0) nu--;
                else nh--;

                if(nh == 0) continue;

                if(dist[nx][ny] < nh + nu) {
                    dist[nx][ny] = nh + nu;
                    queue.add(new Node(nx, ny, nh, nu, temp.time + 1));
                }
            }
        }

        return answer;
    }
    static class Node {
        int x, y;
        int hp;
        int um;
        int time;

        public Node(int x, int y, int hp, int um, int time) {
            this.x = x;
            this.y = y;
            this.hp = hp;
            this.um = um;
            this.time = time;
        }
    }
}
