package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

public class BOJ_10026 {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for(int i=0 ; i<n ; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j=0 ; j<n ; j++) {
                map[i][j] = ch[j];
            }
        }

        visited = new boolean[n][n];
        int redGreen = 0;
        int notRedGreen = 0;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(!visited[i][j]) {
                    BFS(map[i][j], i, j);
                    notRedGreen++;
                }
            }
        }
        visited = new boolean[n][n];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] == 'R')
                    map[i][j] = 'G';
            }
        }
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(!visited[i][j]) {
                    BFS(map[i][j], i, j);
                    redGreen++;
                }
            }
        }
        System.out.println(notRedGreen + " " + redGreen);
    }
    private static void BFS(char ch, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];

            visited[tx][ty] = true;
            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny] && map[nx][ny] == ch) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
