package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_10974 {
    static int n;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n+1];
        recur("",0);
    }
    private static void recur(String str, int cnt) {
        if(cnt == n) {
            System.out.println(str);
            return;
        }

        for(int i=1 ; i<=n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recur(str + i + " ", cnt + 1);
                visited[i] = false;
            }
        }
    }
}
