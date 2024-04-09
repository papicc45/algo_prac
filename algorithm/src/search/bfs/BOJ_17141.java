package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17141 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static ArrayList<int[]> virusZoneList;
    static int[][] virusList;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        virusZoneList = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
                if(map[i][j] == 2) {
                    virusZoneList.add(new int[] {i, j});
                }
            }
        }
        virusList = new int[m][2];
        dfs(0, 0);
        if(result == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }
    private static void dfs(int count, int index) {
        if(count == m) {
            bfs();
            return;
        }

        for(int i=index ; i<virusZoneList.size() ; i++) {
            int[] temp = virusZoneList.get(i);
            virusList[i][0] = temp[0];
            virusList[i][1] = temp[1];
            dfs(count + 1, i+1);
        }
    }
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int answer = 0;
        for(int i=0 ; i<m ; i++) {
            visited[virusList[i][0]][virusList[i][1]] = true;
            queue.add(new int[] {virusList[i][0], virusList[i][1]});
        }

        while (!queue.isEmpty()) {
            if(answer >= result)
                return;

            int size = queue.size();
            for(int i=0 ; i<size ; i++) {
                int[] temp = queue.poll();

                for(int k=0 ; k<4 ; k++) {
                    int nx = temp[0] + dx[k];
                    int ny = temp[1] + dy[k];
                    if(nx>=0 && ny>=0 && nx<n && ny<n) {
                        if(!visited[nx][ny] && map[nx][ny] != 1) {
                            visited[nx][ny] = true;
                            queue.add(new int[] {nx, ny});
                        }
                    }
                }
            }
            answer++;
        }
        boolean check = true;
        for(int i=0 ; i<n ; i++) {
            for(int j=0  ; j<n ; j++) {
                if(!visited[i][j] && map[i][j] != 1) {
                    check = false;
                }
            }
        }
        if(check) {
            result = Math.min(result, answer-1);
        }
    }
}
