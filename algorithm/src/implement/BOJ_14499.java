package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14499 {

    static int n, m;
    static int[][] map;
    static Queue<Integer> commands;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        commands = new LinkedList<>();

        map = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++) {
            commands.add(Integer.parseInt(st.nextToken()));
        }

        solve(sx, sy);
    }
    private static void solve(int x, int y) {
        int[] cols = new int[4]; // 0이 바닥
        int[] rows = new int[4]; // 0이 바닥

        while (!commands.isEmpty()) {
            int command = commands.poll();
            if(command == 1) {
                y = y+1;
                if(!range(x, y)) {
                    y = y-1;
                    continue;
                }

                int r = cols[3];
                for(int i=2 ; i>=0 ; i--)
                    cols[i+1] = cols[i];
                cols[0] = r;

                change(x, y, cols);
                rows[0] = cols[0];
                rows[2] = cols[2];
                System.out.println(cols[2]);
            } else if(command == 2) {
                y = y-1;

                if(!range(x, y)) {
                    y = y+1;
                    continue;
                }

                int r = cols[0];
                for(int i=1 ; i<4 ; i++)
                    cols[i-1] = cols[i];
                cols[3] = r;

                change(x, y, cols);
                rows[0] = cols[0];
                rows[2] = cols[2];
                System.out.println(cols[2]);
            } else if(command == 3) {
                x = x-1;

                if(!range(x, y)) {
                    x = x+1;
                    continue;
                }

                int r = rows[3];
                for(int i=3 ; i>=1 ; i--)
                    rows[i] = rows[i-1];
                rows[0] = r;

                change(x, y, rows);
                cols[0] = rows[0];
                cols[2] = rows[2];
                System.out.println(rows[2]);
            } else {
                x = x+1;

                if(!range(x, y)) {
                    x = x-1;
                    continue;
                }

                int r = rows[0];
                for(int i=1 ; i<4 ; i++)
                    rows[i-1] = rows[i];
                rows[3] = r;

                change(x, y, rows);
                cols[0] = rows[0];
                cols[2] = rows[2];
                System.out.println(rows[2]);
            }
        }
    }
    private static void change(int x, int y, int[] dice) {
        if(map[x][y] == 0) {
            map[x][y] = dice[0];
        } else {
            dice[0] = map[x][y];
            map[x][y] = 0;
        }
    }
    private static boolean range(int x, int y) {
        if(x>=0 && y>=0 && x<n && y<m)
            return true;

        return false;
    }
}
