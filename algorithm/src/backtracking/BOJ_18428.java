package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428 {
    static char[][] map;
    static int n;
    static boolean[][] visited;
    static boolean result = false;
    static ArrayList<int[]> teachers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0 ; i<n ; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0; j<n ; j++) {
                map[i][j] = arr[j].charAt(0);
                if(map[i][j] == 'T')
                    teachers.add(new int[] {i, j});
            }
        }

        recur(0);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    private static boolean check() {
        for(int[] teacher : teachers) {
            int x = teacher[0], y = teacher[1];

            //좌
            for(int i=y-1 ; i>=0 ; i--) {
                if(map[x][i] == 'O') break;
                if(map[x][i] == 'S') return false;
            }

            //우
            for(int i=y+1 ; i<n ; i++) {
                if(map[x][i] == 'O') break;
                if(map[x][i] == 'S') return false;
            }

            //상
            for(int i=x-1 ; i>=0 ; i--) {
                if(map[i][y] == 'O') break;
                if(map[i][y] == 'S') return false;
            }

            //하
            for(int i=x+1 ; i<n ; i++) {
                if(map[i][y] == 'O') break;
                if(map[i][y] == 'S') return false;
            }
        }
        return true;
    }
    private static void recur(int cnt) {
        if(cnt == 3) {
            if(check())
                result = true;

            return;
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(visited[i][j]) continue;
                if(map[i][j] == 'X') {
                    visited[i][j] = true;
                    map[i][j] = 'O';
                    recur(cnt + 1);
                    visited[i][j] = false;
                    map[i][j] = 'X';
                }
            }
        }
    }
}
