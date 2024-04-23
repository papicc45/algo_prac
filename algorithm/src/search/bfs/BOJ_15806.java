package search.bfs;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15806 {
    static int n, t;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        visited = new boolean[2][n][n];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            queue.add(new int[] {x, y, 0});
        }

        bfs();
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            if(visited[t%2][x][y]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");


    }
    private static void bfs() {

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<8 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                int time = temp[2] == 0 ? 1 : 0;
                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[time][nx][ny]) {
                        visited[time][nx][ny] = true;
                        queue.add(new int[] {nx, ny, time});
                    }
                }
            }
        }
    }
}
