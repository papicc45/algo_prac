package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16973 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int n, m;
    static boolean[][] visited;
    static int[][] map;
    static int[][] result;
    static int h, w, sx, sy, fx, fy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken()) ;
        w = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;
        fx = Integer.parseInt(st.nextToken()) - 1;
        fy = Integer.parseInt(st.nextToken()) - 1;

        BFS();
        if(result[fx][fy] == 0)
            System.out.println("-1");
        else
            System.out.println(result[fx][fy]);
    }
    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sx, sy});
        visited[sx][sy] = true;
        int move = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();


            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(!visited[nx][ny] && check(nx, ny)) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                        result[nx][ny] = result[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
    }
    private static boolean check(int x, int y) {
        if(x+h > n || y+w > m)
            return false;

        for(int i=x ; i<x+h ; i++) {
            for(int j=y ; j<y+w ; j++) {
                if(map[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}
