package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Queue<int[]> waterQueue;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        waterQueue = new LinkedList<>();
        queue = new LinkedList<>();
        map = new char[r][c];
        visited = new boolean[r][c];
        for(int i=0 ; i<r ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<c ; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == 'S') {
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
                if(map[i][j] == '*') {
                    waterQueue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        int result = BFS();
        if(result == -1)
            System.out.println("KAKTUS");
        else
            System.out.println(result);


    }
    private static int BFS() {
        while (!queue.isEmpty()) {
            int size = waterQueue.size();
            for(int i=0 ; i<size ; i++) {
                int[] temp = waterQueue.poll();

                for(int j=0 ; j<4 ; j++) {
                    int nx = temp[0] + dx[j];
                    int ny = temp[1] + dy[j];
                    if(range(nx, ny) && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waterQueue.add(new int[] {nx, ny});
                    }
                }
            }
            size = queue.size();
            for(int i=0 ; i<size ; i++) {
                int[] temp = queue.poll();

                for(int j=0 ; j<4 ; j++) {
                    int nx = temp[0] + dx[j];
                    int ny = temp[1] + dy[j];

                    if(range(nx, ny)) {
                        if(map[nx][ny] == 'D') {
                            return temp[2] + 1;
                        } else if(map[nx][ny] == '.') {
                            map[nx][ny] = 'S';
                            queue.add(new int[] {nx, ny, temp[2] + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
    private static boolean range(int x, int y) {
        if(x>=0 && y>=0 && x<r && y<c)
            return true;
        return false;
    }
}
