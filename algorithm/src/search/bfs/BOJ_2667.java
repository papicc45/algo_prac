package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    static int n;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0 ; i<n ; i++) {
            String[] str = br.readLine().split("");
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(Integer i : list) {
            System.out.println(i);
        }
    }
    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                        count++;
                    }
                }
            }
        }
        list.add(count);
    }
}
