package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i=0 ; i<r ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<c ; j++) {
                map[i][j] = arr[j];
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        list.add(map[0][0]);
        visited = new boolean[r][c];
        visited[0][0] = true;
        dfs(0, 0, list);
        System.out.println(result);
    }
    private static void dfs(int x, int y, ArrayList<Character> list) {
        result = Math.max(result, list.size());

        for(int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<r && ny<c) {
                if(!visited[nx][ny] && !list.contains(map[nx][ny])) {
                    visited[nx][ny] = true;
                    list.add(map[nx][ny]);
                    dfs(nx, ny, list);
                    visited[nx][ny] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
