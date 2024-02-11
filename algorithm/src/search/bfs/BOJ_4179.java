package search.bfs;

import javax.naming.ldap.StartTlsRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
    static int n, m;
    static int[] dx = {0, 0, -1 , 1};
    static int[] dy = {-1, 1, 0, 0};

    static char[][] map;
    static int[][] jihun;
    static int[][] fire;
    static int jx, jy;
    static Queue<int[]> fireQueue;
    static Queue<int[]> jihunQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        fire = new int[n][m];
        jihun = new int[n][m];
        fireQueue = new LinkedList<>();
        jihunQueue = new LinkedList<>();

        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<m ; j++) {
                map[i][j] = str.charAt(j);
                jihun[i][j] = -1;
                fire[i][j] = -1;

                if(map[i][j] == 'F') {
                    fireQueue.add(new int[] {i, j});
                    fire[i][j] = 0;
                }
                if(map[i][j] == 'J') {
                    jihunQueue.add(new int[] {i, j});
                    jihun[i][j] = 0;
                }
            }
        }
        fireMove();
        jihunMove();
    }
    private static void fireMove() {
        while (!fireQueue.isEmpty()) {
            int[] temp = fireQueue.poll();
            int tx = temp[0];
            int ty = temp[1];

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m)
                    continue;
                if(fire[nx][ny] >= 0 || map[nx][ny] == '#')
                    continue;
                fire[nx][ny] = fire[tx][ty] + 1;
                fireQueue.add(new int[] {nx, ny});
            }
        }
    }
    private static void jihunMove() {
        while (!jihunQueue.isEmpty()) {
            int[] temp = jihunQueue.poll();
            int tx = temp[0];
            int ty = temp[1];

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx==n || ny==m) {
                    System.out.println(jihun[tx][ty] + 1);
                    return;
                }

                if(jihun[nx][ny] >= 0 || map[nx][ny] == '#')
                    continue;
                if(fire[nx][ny] <= jihun[tx][ty] + 1)
                    continue;

                jihun[nx][ny] = jihun[tx][ty] + 1;
                jihunQueue.add(new int[] {nx, ny});

            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
