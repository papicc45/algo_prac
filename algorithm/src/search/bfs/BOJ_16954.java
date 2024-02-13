package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16954 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0, 0, -1, 1, -1, 1};
    static int[] dx = {0, -1, 0, 1, 0, 1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[8][8];

        for(int i=0 ; i<8 ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<8 ; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        System.out.println(BFS());

    }
    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {7, 0});

        while (!queue.isEmpty()) {
            visited = new boolean[8][8];
            int len = queue.size();

            for(int i=0 ; i<len ; i++) {
                int[] temp = queue.poll();

                int tx = temp[0];
                int ty = temp[1];

                if(map[tx][ty] == '#') continue;
                if(tx == 0 && ty == 7)
                    return 1;


                for(int j=0 ; j<9 ; j++) {
                    int nx = tx + dx[j];
                    int ny = ty + dy[j];

                    if(nx>=0 && ny>=0 && nx<8 && ny<8) {
                        if(!visited[nx][ny] && map[nx][ny] != '#') {
                            queue.add(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            moveWall();
        }
        return 0;
    }
    private static void moveWall() {
        for(int i=7 ; i>=0 ; i--) {
            for(int j=0 ; j<8 ; j++) {
                if(map[i][j] == '#') {
                    map[i][j] = '.';

                    if(i != 7) {
                        map[i+1][j] = '#';
                    }
                }

            }
        }
    }

}
