package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2194 {
    static int n, m;
    static int a, b;
    static int k;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    static int startX, startY;
    static int endX, endY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        System.out.println(BFS(startX, startY));
    }
    private static int  BFS(int x, int y) {
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int count = temp[2];
            if(tx == endX && ty == endY)
                return count;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(!range(nx, ny))
                    continue;
                if(!check(nx ,ny))
                    continue;

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny, count + 1});
            }
        }
        return -1;
    }
    private static boolean range(int x, int y) {
        if(x>=1 && x<=n && y>=1 && y<=m)
            return true;
        return false;
    }
    private static boolean check(int x, int y) {
        if(visited[x][y])
            return false;

        for(int i=x ; i<x+a ; i++) {
            for(int j=y ; j<y+b ; j++) {
                if(!range(i, j))
                    return false;
                if(map[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}
