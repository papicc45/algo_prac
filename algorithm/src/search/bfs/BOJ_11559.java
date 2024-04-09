package search.bfs;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 {
    static char[][] map;
    static boolean[][] visited;
    static boolean check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for(int i=0 ; i<12 ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<6 ; j++) {
                map[i][j] = arr[j];
            }
        }
        int result = 0;
        while (true) {
            bfs();
            floorIsBlank();
            if(!check) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }
    private static void floorIsBlank() {
        for(int i=11 ; i>=0 ; i--) {
            for(int j=0 ; j<6 ; j++) {
                if(map[i][j] == '.') {
                    down(i, j);
                }
            }
        }
    }
    private static void down(int i, int j) {
        int len = i;
        boolean b = false;
        while (--len >= 0) {
            if (map[len][j] != '.') {
                b = true;
                break;
            }
        }
        if(b) {
            map[i][j] = map[len][j];
            map[len][j] = '.';
        }
    }
    private static void bfs() {
        check = false;
        visited = new boolean[12][6];
        for(int i=0 ; i<12 ; i++) {
            for(int j=0 ; j<6 ; j++) {
                if(!visited[i][j] && map[i][j] != '.') {
                    char ch = map[i][j];
                    Queue<int[]> queue = new LinkedList<>();
                    ArrayList<int[]> list = new ArrayList<>();
                    queue.add(new int[] {i, j});
                    list.add(new int[] {i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();

                        for(int k=0 ; k<4 ; k++) {
                            int nx = temp[0] + dx[k];
                            int ny = temp[1] + dy[k];

                            if(nx>=0 && ny>=0 && nx<12 && ny<6) {
                                if(!visited[nx][ny] && map[nx][ny] == ch) {
                                    visited[nx][ny] = true;
                                    queue.add(new int[] {nx, ny});
                                    list.add(new int[] {nx, ny});
                                }
                            }
                        }
                    }

                    if(list.size() >= 4) {
                        for(int[] value : list) {
                            map[value[0]][value[1]] = '.';
                        }
                        check = true;
                    }
                }
            }
        }
    }
}
