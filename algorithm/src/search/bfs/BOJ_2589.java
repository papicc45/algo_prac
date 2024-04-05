package search.bfs;

import java.awt.image.ImagingOpException;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
    static int x, y;
    static int[] dx = {0, 0, -1 , 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new char[x][y];
        visited = new boolean[x][y];

        for(int i=0 ; i<x ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<y ; j++) {
                map[i][j] = arr[j];
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=0 ; i<x ; i++) {
            for(int j=0 ; j<y ; j++) {
                if(map[i][j] == 'L') {
                    result = Math.max(result, BFS(i, j));
                }
            }
        }

        System.out.println(result);
    }
    private static int BFS(int tx, int ty) {
        int result = Integer.MIN_VALUE;
        visited = new boolean[x][y];
        int[][] counts = new int[x][y];
        for(int i=0 ; i<x ; i++) {
            Arrays.fill(counts[i], Integer.MAX_VALUE);
        }

        visited[tx][ty] = true;
        counts[tx][ty] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {tx, ty});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<x && ny<y) {
                    if(!visited[nx][ny] && map[nx][ny] == 'L') {
                        visited[nx][ny] = true;
                        counts[nx][ny] = Math.min(counts[nx][ny], counts[temp[0]][temp[1]] + 1);
                        result = Math.max(result, counts[nx][ny]);
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return result;
    }
}
