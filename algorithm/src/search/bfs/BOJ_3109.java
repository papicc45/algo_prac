package search.bfs;

import java.awt.geom.FlatteningPathIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3109 {
    static int r, c;
    static char[][] map;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static boolean[][] visited;
    static int result = 0;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i=0 ; i<r ; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j=0 ; j<c ; j++) {
                map[i][j] = ch[j];
            }
        }
        visited = new boolean[r][c];
        for(int i=0 ; i<r ; i++) {
            check = false;
            dfs(i, 0);
        }
        System.out.println(result);
    }
    private static void dfs(int x, int y) {
        if(y == c-1) {
            check = true;
            result++;
            visited[x][y] = true;
            return;
        }

        for(int i=0 ; i<3 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<r && ny<c) {
                if(!visited[nx][ny] && map[nx][ny] == '.') {
                    dfs(nx, ny);
                    visited[x][y] = true;
                    if(check)
                        return;
                }
            }
        }
    }
}
