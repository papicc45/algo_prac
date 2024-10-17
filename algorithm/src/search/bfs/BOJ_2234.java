package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2234 {
    static int n, m;
    static Block[][] blocks;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        blocks = new Block[n][m];



        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                int num = Integer.parseInt(st.nextToken());

                int west = ((num & 1) != 0) ? 1 : 0;
                int north = ((num & 2) != 0) ? 1 : 0;
                int east = ((num & 4) != 0) ? 1 : 0;
                int south = ((num & 8) != 0) ? 1 : 0;
                blocks[i][j] = new Block(0, east, west, south, north, 0);
            }
        }

        int idx = 1;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(!blocks[i][j].v) {
                    bfs(i, j, idx++);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
        int sumMax = 0;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                for(int k=0 ; k<4 ; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if(blocks[i][j].index != blocks[nx][ny].index) {
                        sumMax = Math.max(sumMax, blocks[i][j].width + blocks[nx][ny].width);
                    }
                }
            }
        }
        System.out.println(sumMax);
    }
    private static void bfs(int x, int y, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        blocks[x][y].v = true;
        ArrayList<int[]> list = new ArrayList<>();
        int count = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0], ty = temp[1];
            list.add(new int[] {tx, ty});
            count++;

            for(int i=0 ; i<4 ; i++) {
                if(i == 0 && blocks[tx][ty].east == 1) continue;
                if(i == 1 && blocks[tx][ty].west == 1) continue;
                if(i == 2 && blocks[tx][ty].south == 1) continue;
                if(i == 3 && blocks[tx][ty].north == 1) continue;

                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(blocks[nx][ny].v) continue;

                blocks[nx][ny].v = true;
                queue.add(new int[] {nx, ny});
            }
        }
        max = Math.max(count, max);
        for(int[] temp : list) {
            int tx = temp[0], ty = temp[1];
            blocks[tx][ty].index = idx;
            blocks[tx][ty].width = count;
        }
    }
    static class Block {
        int index;
        int east;
        int west;
        int south;
        int north;
        int width;
        boolean v;

        public Block(int index, int east, int west, int south, int north, int width) {
            this.index = index;
            this.east = east;
            this.west = west;
            this.south = south;
            this.north = north;
            this.width = width;
            this.v = false;
        }
    }
}
