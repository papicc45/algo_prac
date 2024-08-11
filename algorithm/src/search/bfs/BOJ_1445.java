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
    static int[][] arr1;
    static int[][] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        arr1 = new int[n][m];
        arr2 = new int[n][m];

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
            Arrays.fill(arr1[i], Integer.MAX_VALUE);
            Arrays.fill(arr2[i], Integer.MAX_VALUE);
        }
        arr1[xs][ys] = 0;
        arr2[xs][ys] = 0;
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

            int ng2 = 0;
            int ng1 = 0;
            if(map[tx][ty] == '.') {
                for(int i=0 ; i<4 ; i++) {
                    int nx = tx + dx[i];
                    int ny = tx + dy[i];

                    if(check(nx, ny) && map[nx][ny] == 'g') ng2++;
                }
            } else if(map[tx][ty] == 'g') {
                ng1++;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(!check(nx, ny)) continue;
                if(visited[nx][ny]) continue;


                queue.add(new Road(nx, ny, g1 + ng1, g2 + ng2));
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
