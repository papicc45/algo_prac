package search.dfs;

import java.util.Scanner;

public class BOJ_10164 {
    static int n, m, k;
    static int result = 0;
    static boolean[][] visited;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        int num = 1;
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                arr[i][j] = num++;
            }
        }

        visited[0][0] = true;
        if(k == 0)
            dfs(0, 0, true);
        else
            dfs(0, 0, false);

        System.out.println(result);
    }
    private static void dfs(int x, int y, boolean check) {
        if((x+1) * (y+1) == n*m && check) {
            result++;
            return;
        }
        if(!check && arr[x][y] == k) {
            check = true;
        }
        if(range(x+1, y) && !visited[x+1][y]) {
            visited[x+1][y] = true;
            dfs(x+1, y, check);
            visited[x+1][y] = false;
        }

        if(range(x, y+1) && !visited[x][y+1]) {
            visited[x][y+1] = true;
            dfs(x, y+1, check);
            visited[x][y+1] = false;
        }


    }
    private static boolean range(int x, int y) {
        if(x>=0 && y>=0 && x<n && y<m)
            return true;

        return false;
    }
}
