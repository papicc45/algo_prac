package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12886 {
    static boolean[][]visited = new boolean[1501][1501];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(bfs(a, b, c) ? 1 : 0);
    }
    private static boolean bfs(int a, int b, int c) {
        if((a + b + c) % 3 != 0)
            return false;

        Queue<int[]> queue = new LinkedList<>();
        visited[a][b] = true;
        queue.add(new int[] {a, b, c});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int ta = temp[0];
            int tb = temp[1];
            int tc = temp[2];

            if(ta == tb && ta == tc)
                return true;

            if(ta != tb) {
                int na = ta > tb ? ta-tb : ta+ta;
                int nb = ta > tb ? tb+tb : tb-ta;

                if(!visited[na][nb]) {
                    visited[na][nb] = true;
                    queue.add(new int[] {na, nb, tc});
                }
            }
            if(tb != tc) {
                int nb = tb > tc ? tb-tc : tb+tb;
                int nc = tb > tc ? tc+tc : tc-tb;

                if(!visited[nb][nc]) {
                    visited[nb][nc] = true;
                    queue.add(new int[] {ta, nb, nc});
                }
            }

            if(ta != tc) {
                int na = ta >  tc ? ta-tc : ta+ta;
                int nc = ta > tc ? tc+tc : tc-ta;

                if(!visited[na][nc]) {
                    visited[na][nc] = true;
                    queue.add(new int[] {na, tb, nc});
                }
            }
        }
        return false;
    }
}
