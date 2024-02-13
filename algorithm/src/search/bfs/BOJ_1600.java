package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.MembershipKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static int k, w, h;
    static int[][] map;
    static boolean[][][] visited;
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {-1, 1, 0, 0};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k+1];

        for(int i=0 ; i<h ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<w ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = BFS();
        System.out.println(result);
    }
    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int horseCount = temp[2];
            int monkeyCount = temp[3];

            if(tx == h-1 && ty == w-1)
                return monkeyCount;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + mx[i];
                int ny = ty + my[i];

                if(nx>=0 && ny>=0 && nx<h && ny<w) {
                    if(map[nx][ny] == 0 && !visited[nx][ny][horseCount]) {
                        visited[nx][ny][horseCount] = true;
                        queue.add(new int[] {nx, ny, horseCount, monkeyCount + 1});
                    }
                }
            }
            if(horseCount < k) {
                for(int i=0 ; i<8 ; i++) {
                    int nx = tx + hx[i];
                    int ny = ty + hy[i];

                    if(nx>=0 && ny>=0 && nx<h && ny<w) {
                        if(map[nx][ny] == 0 && !visited[nx][ny][horseCount+1]) {
                            queue.add(new int[] {nx, ny, horseCount + 1, monkeyCount + 1});
                            visited[nx][ny][horseCount+1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
