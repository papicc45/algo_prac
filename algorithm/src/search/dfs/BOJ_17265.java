package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17265 {
    static char[][] map;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, map[0][0] - '0', map[0][0]);
        System.out.println(max + " " + min);

    }
    private static void dfs(int x, int y, int before, char operation) {
        int temp = map[x][y] - '0';
        if(temp >=0 && temp<=5) {
            if(operation == '+')
                before += temp;
            else if(operation == '-')
                before -= temp;
            else if(operation == '*')
                before *= temp;
        } else {
            operation = map[x][y];
        }

        if(x == n-1 && y == n-1) {
            max = Math.max(max, before);
            min = Math.min(min, before);
            return;
        }

        if (x + 1 < n)
            dfs(x+1, y, before, operation);

        if(y + 1 < n)
            dfs(x, y+1, before, operation);
    }
}
