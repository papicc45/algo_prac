package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558 {
    static int[][] map;
    static int[] direct = {-1, 1};
    static boolean[][] visited;
    static int n, k;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[2][n];
        visited = new boolean[2][n];

        String str = br.readLine();
        for(int i=0 ; i<n ; i++) {
            map[0][i] = str.charAt(i) - '0';
        }
        str = br.readLine();
        for(int i=0 ; i<n ; i++) {
            map[1][i] = str.charAt(i) - '0';
        }
        queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int deleteIndex = 0;
        while (queue.size() != 0) {
            if(BFS()) {
                System.out.println(1);
                return;
            }
            if(deleteIndex < n) {
                delete(deleteIndex++);
            }
        }
        System.out.println(0);
    }
    private static void delete(int i) {
        visited[0][i] = true;
        visited[1][i] = true;
    }
    private static boolean BFS() {
        int size = queue.size();
        for(int t=0 ; t<size ; t++) {
            int[] temp = queue.poll();
            if(visited[temp[0]][temp[1]])
                continue;

            visited[temp[0]][temp[1]] = true;
            int nx = temp[0];
            for(int i=0 ; i<2 ; i++) {
                int ny = temp[1] + direct[i];
                if(ny >= n) {
                    return true;
                }
                if(ny>=0 && ny<n && map[nx][ny] == 1) {
                    if(!visited[nx][ny]) {
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
            int jump = temp[0] == 0 ? 1 : 0;
            int cal = temp[1] + k;
            if(temp[1] + k < n) {
                if(map[jump][temp[1] + k] == 1) {
                    queue.add(new int[] {jump, temp[1] + k});
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
