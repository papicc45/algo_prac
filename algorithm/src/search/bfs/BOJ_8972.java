package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_8972 {
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};

    static int r, c;
    static char[][] map;
    static boolean end = false;
    static int jx, jy;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i=0 ; i<r ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<c ; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == 'R') {
                    queue.add(new int[] {i, j});
                } else if(map[i][j] == 'I') {
                    jx = i;
                    jy = j;
                }
            }
        }
        char[] command = br.readLine().toCharArray();
        int i=0;
        for( ; i<command.length ; i++) {
            int c = command[i] - '0';
            map[jx][jy] = '.';
            jx += dx[c];
            jy += dy[c];
            if(map[jx][jy] == 'R') {
                end = true;
                break;
            }
            map[jx][jy] = 'I';

            madArduinoMove();
            if(end)
                break;

            mapRefresh();
        }
        if(end)
            System.out.println("kraj " + (i+1));
        else {
            for(int j=0 ; j<r ; j++) {
                for(int k=0 ; k<c ; k++) {
                    System.out.print(map[j][k]);
                }
                System.out.println();
            }
        }
    }
    private static void mapRefresh() {
        for(int i=0 ; i<r ; i++)
            Arrays.fill(map[i], '.');

        map[jx][jy] = 'I';
        int size = queue.size();
        for(int i=0 ; i<size ; i++) {
            int[] node = queue.poll();
            map[node[0]][node[1]] = 'R';
            queue.add(new int[] {node[0], node[1]});
        }
    }
    private static void madArduinoMove() {
        int[][] count = new int[r][c];

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];

            int min = Integer.MAX_VALUE;
            int d = 0;
            for(int i=1 ; i<10 ; i++) {
                if(i == 5)
                    continue;

                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=r || ny>=c) continue;

                int diff = Math.abs(jx-nx) + Math.abs(jy-ny);

                if(diff < min) {
                    min = diff;
                    d = i;
                }
            }
            int gx = tx + dx[d];
            int gy = ty + dy[d];

            if(map[gx][gy] == 'I') {
                end = true;
                return;
            }

            count[gx][gy] += 1;
        }
        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                if(count[i][j] == 1)
                    queue.add(new int[] {i, j});
            }
        }
    }
}
