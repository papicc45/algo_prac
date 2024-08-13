package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1445 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static int n, m;
    static int xs, ys, xe, ye;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<m ; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == 'F') {
                    xe = i;
                    ye = j;
                } else if(map[i][j] == 'S') {
                    xs = i;
                    ys = j;
                }
            }
        }
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(map[i][j] == 'g') {
                    for(int k=0 ; k<4 ; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(!check(nx, ny)) continue;
                        if(map[nx][ny] == 'S' || map[nx][ny] == 'F' || map[nx][ny] == 'g') continue;;
                        map[nx][ny] = 'G';
                    }
                }
            }
        }
        int[] result = bfs();
        System.out.println(result[0] + " " + result[1]);
    }
    private static boolean check(int x, int y) {
        if(x<0 || x>=n || y<0 || y>=m) return false;

        return true;
    }
    private static int[] bfs() {
        int[] answer = new int[2];
        PriorityQueue<Road> queue = new PriorityQueue<>();
        queue.add(new Road(xs, ys, 0, 0));

        while (!queue.isEmpty()) {
            Road road = queue.poll();
            int tx = road.x;
            int ty = road.y;
            int g1 = road.g1;
            int g2 = road.g2;

            if(tx == xe && ty == ye) {
                answer[0] = g1;
                answer[1] = g2;
                break;
            }

            if(visited[tx][ty]) continue;
            visited[tx][ty] = true;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(!check(nx, ny)) continue;
                if(visited[nx][ny]) continue;

                int ng1 = g1;
                int ng2 = g2;
                if(map[nx][ny] == 'G') {
                    ng2++;
                } else if(map[nx][ny] == 'g') {
                    ng1++;
                }
                queue.add(new Road(nx, ny, ng1, ng2));
            }
        }
        return answer;
    }
    static class Road implements Comparable<Road> {
        int x;
        int y;
        int g1;
        int g2;

        public Road(int x, int y, int g1, int g2) {
            this.x = x;
            this.y = y;
            this.g1 = g1;
            this.g2 = g2;
        }

        @Override
        public int compareTo(Road o) {
            if(this.g1 == o.g1) {
                return this.g2 - o.g2;
            } else {
                return this.g1 - o.g1;
            }
        }
    }
}
