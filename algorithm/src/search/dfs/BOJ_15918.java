package search.dfs;

import javax.swing.plaf.nimbus.State;
import java.util.Scanner;

public class BOJ_15918 {
    static int n, x, y;
    static int[] arr;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        arr = new int[n*2+1];
        visited = new boolean[n+1];

        arr[x] = arr[y] = y - x - 1;
        visited[y - x - 1] = true;
        recur(1);

        System.out.println(result);
    }
    private static void recur(int index) {
        if(index == n*2) {
            result++;
            return;
        }

        if(arr[index] == 0) {
            for(int i=1 ; i<=n ; i++) {
                if(visited[i])
                    continue;
                int otherSide = i + index + 1;
                if(otherSide <= 2 * n && arr[otherSide] == 0) {
                    arr[index] = arr[otherSide] = i;
                    visited[i] = true;
                    recur(index + 1);
                    arr[index] = arr[otherSide] = 0;
                    visited[i] = false;
                }
            }
        } else {
            recur(index + 1);
        }
    }
}
