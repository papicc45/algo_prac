package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int oc = 0, vc = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                map[i][j] = arr[j];
            }
        }
        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                if(map[i][j] != '#' && !visited[i][j])
                    bfs(i, j);
            }
        }
        System.out.println(oc + " " + vc);
    }
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] {x, y});

        int o = 0, v = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0], ty = temp[1];
            if(map[tx][ty] == 'o')
                o++;
            else if(map[tx][ty] == 'v')
                v++;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx<0 || ny<0 || nx>=r || ny>=c || visited[nx][ny]) continue;
                if(map[nx][ny] == '#') continue;
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
            }
        }

        if(o > v)
            oc += o;
        else
            vc += v;
    }
}
