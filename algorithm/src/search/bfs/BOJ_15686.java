package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {
    static int n, m;
    static int[][] map;
    static boolean[] check;

    static ArrayList<int[]> houses;
    static ArrayList<int[]> chickens;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    chickens.add(new int[] {i, j});
                } else if(map[i][j] == 1) {
                    houses.add(new int[] {i, j});
                }
            }
        }

        check = new boolean[chickens.size()];
        recur(0, 0);

        System.out.println(result);

    }
    private static void recur(int index, int depth) {
        if(depth == m) {

            int sum = 0;
            for(int[] house : houses) {
                int min = Integer.MAX_VALUE;

                for(int i=0 ; i<chickens.size() ; i++) {
                    if(check[i]) {
                        min = Math.min(min, Math.abs(house[0] - chickens.get(i)[0]) + Math.abs(house[1] - chickens.get(i)[1]));
                    }
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for(int i=index ; i<chickens.size() ; i++) {
            if(!check[i]) {
                check[i] = true;
                recur(i + 1, depth + 1);
                check[i] = false;
            }
        }
    }
}
