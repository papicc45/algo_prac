package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142 {
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> virusList = new ArrayList<>();
    static boolean[] virusVisited;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    virusList.add(new int[]{i, j});
            }
        }
        virusVisited = new boolean[virusList.size()];
        for(int i=0 ; i<virusVisited.length ; i++) {
            virusVisited[i] = true;
            ArrayList<int[]> list = new ArrayList<>();
            list.add(new int[] {virusList.get(i)[0], virusList.get(i)[1]});
            recur(list, 1);
        }
        if(result == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(result);
    }
    private static void recur(ArrayList<int[]> list, int cnt) {
        if(cnt == m) {
            result = Math.min(result, bfs(list));
            return;
        }

        for(int i=0 ; i<virusVisited.length ; i++) {
            if(!virusVisited[i]) {
                virusVisited[i] = true;
                list.add(new int[] {virusList.get(i)[0], virusList.get(i)[1]});
                recur(list, cnt + 1);
                virusVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    private static int bfs(ArrayList<int[]> list) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[][] copyMap = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        for(int[] arr : list) {
            queue.add(arr);
            visited[arr[0]][arr[1]] = true;
        }

        int cnt = 0;
        while (!check(copyMap)) {
            int size = queue.size();
            if(size == 0) {
                return Integer.MAX_VALUE;
            }
            for(int i=0 ; i<size ; i++) {
                int[] temp = queue.poll();

                for(int j=0 ; j<4 ; j++) {
                    int nx = temp[0] + dx[j];
                    int ny = temp[1] + dy[j];

                    if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                    if(visited[nx][ny]) continue;
                    if(copyMap[nx][ny] == 1) continue;

                    visited[nx][ny] = true;
                    copyMap[nx][ny] = 2;
                    queue.add(new int[] {nx, ny});
                }
            }
            cnt++;
        }
        return cnt;
    }
    private static boolean check(int[][] copyMap) {
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(copyMap[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
