package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

public class BOJ_6593 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dz = {-1, 1};

    static int l, r, c;
    static char[][][] building;
    static boolean[][][] visited;
    static int sz, sx, sy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break;

            building = new char[l][r][c];
            visited = new boolean[l][r][c];

            for(int i=0 ; i<l ; i++) {
                for(int j=0 ; j<r ; j++) {
                    char[] arr = br.readLine().toCharArray();
                    for(int k=0 ; k<c ; k++) {
                        building[i][j][k] = arr[k];
                        if(building[i][j][k] == 'S') {
                            sz = i;
                            sx = j;
                            sy = k;
                        }
                    }
                }
                br.readLine();
            }
            int result = bfs();

            if(result == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }
    private static int bfs() {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited[sz][sx][sy] = true;
        queue.add(new int[]{sz,sx,sy, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tz = temp[0];
            int tx = temp[1];
            int ty = temp[2];
            int count = temp[3];


            if(building[tz][tx][ty] == 'E') {
                result = count;
                break;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<r && ny<c && !visited[tz][nx][ny]) {
                    if(building[tz][nx][ny] == '.' || building[tz][nx][ny] == 'E') {
                        queue.add(new int[] {tz,nx,ny,count + 1});
                        visited[tz][nx][ny] = true;
                    }
                }
            }
            for(int i=0 ; i<2 ; i++) {
                int nz = tz + dz[i];

                if(nz>=0 && nz<l && !visited[nz][tx][ty]) {
                    if(building[nz][tx][ty] == '.' || building[nz][tx][ty] == 'E') {
                        queue.add(new int[] {nz,tx,ty,count + 1});
                        visited[nz][tx][ty] = true;
                    }
                }
            }
        }
        return result;
    }
}
