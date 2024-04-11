package simulation;

import javax.swing.plaf.ComponentUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> cctvList;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cctvList = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0 ; j<m ; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
                if(map[i][j] >=1 && map[i][j] <= 5) {
                    cctvList.add(new int[] {i, j, map[i][j]});
                }
            }
        }
        recur(map, 0);
        System.out.println(result);
    }
    private static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[n][m];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }
    private static void recur(int[][] origin,  int count) {
        if(count == cctvList.size()) {
            int blind = 0;
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<m ; j++) {
                    if(origin[i][j] == 0)
                        blind++;
                }
            }
            result = Math.min(result, blind);
            return;
        }

        int[] cctv = cctvList.get(count);
        int x = cctv[0], y = cctv[1];
        int number = cctv[2];
        int[][] copy;
        if(number == 1) {
            copy = copyMap(origin);
            east(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            west(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            south(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            north(copy, x, y);
            recur(copy, count + 1);
        } else if(number == 2) {
            copy = copyMap(origin);
            east(copy, x, y);
            west(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            south(copy, x, y);
            north(copy, x, y);
            recur(copy, count + 1);
        } else if(number == 3) {
            copy = copyMap(origin);
            north(copy, x, y);
            east(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            east(copy, x, y);
            south(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            south(copy, x, y);
            west(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            west(copy, x, y);
            north(copy, x, y);
            recur(copy, count + 1);
        } else if(number == 4) {
            copy = copyMap(origin);
            west(copy, x, y);
            north(copy, x, y);
            east(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            north(copy, x, y);
            east(copy, x, y);
            south(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            east(copy, x, y);
            south(copy, x, y);
            west(copy, x, y);
            recur(copy, count + 1);

            copy = copyMap(origin);
            south(copy, x, y);
            west(copy, x, y);
            north(copy, x, y);
            recur(copy, count + 1);
        } else {
            copy = copyMap(origin);
            east(copy, x, y);
            west(copy, x, y);
            north(copy, x, y);
            south(copy, x, y);
            recur(copy, count + 1);
        }
    }
    private static void east(int[][] copy, int x, int y) {
        for(int i=y+1 ; i<m ; i++) {
            if(copy[x][i] != 6)
                copy[x][i] = 7;
            else
                return;
        }
    }
    private static void west(int[][] copy, int x, int y) {
        for(int i=y-1 ; i>=0 ; i--) {
            if(copy[x][i] != 6)
                copy[x][i] = 7;
            else
                return;
        }
    }
    private static void south(int[][] copy, int x, int y) {
        for(int i=x+1 ; i<n ; i++) {
            if(copy[i][y] != 6)
                copy[i][y] = 7;
            else
                return;
        }
    }

    private static void north(int[][] copy, int x, int y) {
        for(int i=x-1 ; i>=0 ; i--) {
            if(copy[i][y] != 6)
                copy[i][y] = 7;
            else
                return;
        }
    }
}
