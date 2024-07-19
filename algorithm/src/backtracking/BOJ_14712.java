package backtracking;

import java.util.DuplicateFormatFlagsException;
import java.util.Scanner;

public class BOJ_14712 {
    static int n, m;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n][m];
        recur(0, 0);
        System.out.println(result);

    }
    private static boolean check(int c) {
        if(c < 4)
            return true;

        for(int i=0 ; i<n-1 ; i++) {
            for(int j=0 ; j<m-1 ; j++) {
                if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void recur(int c, int idx) {
        if(check(c))
            result++;

        if(c == n*m)
            return;

        for(int i=idx ; i<n*m ; i++) {
            int x = i / m;
            int y = i % m;

            if(!visited[x][y]) {
                visited[x][y] = true;
                recur(c + 1, i + 1);
                visited[x][y] = false;
            }
        }
    }
}
