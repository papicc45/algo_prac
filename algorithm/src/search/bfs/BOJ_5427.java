package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
    static int w, h;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> fires;
    static Queue<int[]> queue;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fires = new LinkedList<>();
            queue = new LinkedList<>();
            for(int i=0 ; i<h ; i++) {
                char[] arr = br.readLine().toCharArray();
                for(int j=0 ; j<w ; j++) {
                    map[i][j] = arr[j];
                    if(map[i][j] == '*') {
                        fires.add(new int[] {i, j});
                    } else if(map[i][j] == '@') {
                        queue.add(new int[] {i, j, 0});
                    }
                }
            }
            result = 0;
            visited = new boolean[h][w];
            while (queue.size() != 0) {
                fire();
                bfs();
                if(result != 0)
                    break;
            }
            if(result == 0)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(result);
        }
    }
    private static void bfs() {
        int size = queue.size();
        for(int i=0 ; i<size ; i++) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int day = temp[2];
            if (tx == 0 || tx == h - 1) {
                result = day + 1;
                return;
            }
            if (ty == 0 || ty == w - 1) {
                result = day + 1;
                return;
            }
            for (int k=0; k<4; k++) {
                int nx = tx + dx[k];
                int ny = ty + dy[k];
                if (rangeCheck(nx, ny)) {
                    if (!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, day + 1});
                    }
                }
            }
        }
    }
    private static void fire() {
        int size = fires.size();
        for(int i=0 ; i<size ; i++) {
            int[] temp = fires.poll();
            int tx = temp[0];
            int ty = temp[1];

            for(int k=0 ; k<4 ; k++) {
                int nx = tx + dx[k];
                int ny = ty + dy[k];
                if(rangeCheck(nx, ny)) {
                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        fires.add(new int[] {nx, ny});
                    }
                }
            }

        }
    }
    private static boolean rangeCheck(int x, int y) {
        return x>=0 && y>=0 && x<h && y<w;
    }
}
