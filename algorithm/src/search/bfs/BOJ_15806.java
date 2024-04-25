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
        visited = new boolean[n][n][2];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            queue.add(new int[] {x, y, 0});
            visited[x][y][0] = true;
        }
        int nt = t;
        while (nt-- > 0) {
            bfs();
        }
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            if(visited[x][y][t%2]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");


    }
    private static void bfs() {
        int size = queue.size();
        for(int i=0 ; i<size ; i++) {

            int[] temp = queue.poll();

            visited[temp[0]][temp[1]][temp[2]] = false;

            for(int j=0 ; j<8 ; j++) {
                int nx = temp[0] + dx[j];
                int ny = temp[1] + dy[j];
                int time = temp[2] == 0 ? 1 : 0;
                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny][time]) {
                        visited[nx][ny][time] = true;
                        queue.add(new int[] {nx, ny, time});
                    }
                }
            }
        }
    }
}
