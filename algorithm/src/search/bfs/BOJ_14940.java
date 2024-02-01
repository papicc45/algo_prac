package search.bfs;

import javax.naming.ldap.StartTlsRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1 ,1, 0, 0};
    static int x, y;
    static int[][] map;
    static boolean[][] visited;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[x][y];
        visited = new boolean[x][y];
        answer = new int[x][y];

        int startX = 0;
        int startY = 0;
        for(int i=0 ; i<x ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<y ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        BFS(startX, startY);

        for(int i=0 ; i<x ; i++) {
            for(int j=0 ; j<y ; j++) {
                if(map[i][j] == 1 && answer[i][j] == 0) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(answer[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
    private static void BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int count = temp[2];
            answer[tx][ty] = count;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<x && ny<y) {
                    if(!visited[nx][ny] && map[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, count+1});
                    }
                }
            }
        }
    }
}
