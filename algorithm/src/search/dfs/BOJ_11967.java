package search.dfs;

import java.awt.*;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.PolicyQualifierInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11967 {
    static ArrayList<Point>[][] list;
    static int n, m;
    static int result = 1;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] lights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1][n+1];
        for(int i=0 ; i<=n ; i++) {
            for(int j=0 ; j<=n ; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            list[x][y].add(new Point(lx, ly));
        }

        bfs();
        System.out.println(result);
    }
    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        visited = new boolean[n+1][n+1];
        lights = new boolean[n+1][n+1];
        lights[1][1] = true;
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            boolean check = false;
            for(Point point : list[temp.x][temp.y]) {
                if(!lights[point.x][point.y]) {
                    check = true;
                    lights[point.x][point.y] = true;
                    result++;
                }
            }
            if(check) {
                visited = new boolean[n+1][n+1];
                visited[temp.x][temp.y] = true;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx>0 && ny>0 && nx<=n && ny<=n) {
                    if(!visited[nx][ny] && lights[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }

        }
    }
}
