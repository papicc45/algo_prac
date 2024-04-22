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
    static int[][] map;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<int[]> clean;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        clean = new ArrayList<>();
        map = new int[n][n];
        visited = new boolean[10002][n][n];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            queue.add(new int[] {x, y, 0});
            visited[0][x][y] = true;
        }

        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            clean.add(new int[] {x, y});
        }
        boolean check = bfs();

//        boolean check = false;
//        for(int[] arr : clean) {
//            int x = arr[0];
//            int y = arr[1];
//            if(map[x][y] >= 1)
//                check = true;
//        }
        if(check)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
    private static boolean bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int time = temp[2];

            if(time == t) {
                for(int[] spot : clean) {
                    if(tx == spot[0] && ty == spot[1]) {
                        return true;
                    }
                }
            }
            for(int i=0 ; i<8 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[time+1][nx][ny]) {
                        visited[time+1][nx][ny] = true;
                        map[nx][ny]++;
                        queue.add(new int[] {nx, ny, time + 1});
                    }
                }
            }
        }
        return false;
//        int size = queue.size();
//        visited = new boolean[n][n];
//
//        for(int k=0 ; k<size ; k++) {
//            int[] temp = queue.poll();
//
//            for(int i=0 ; i<8 ; i++) {
//                int nx = temp[0] + dx[i];
//                int ny = temp[1] + dy[i];
//
//                if(nx>=0 && ny>=0 && nx<n && ny<n) {
//                    if(!visited[nx][ny]) {
//                        visited[nx][ny] = true;
//                        queue.add(new int[] {nx, ny});
//                        map[nx][ny]++;
//                    }
//                }
//            }
//            map[temp[0]][temp[1]]--;
//        }
    }
}
