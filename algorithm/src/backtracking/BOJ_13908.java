package backtracking;

import java.util.Scanner;

public class BOJ_13908 {
    static boolean[] visited;
    static int n, m;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[10];
        for(int i=0 ; i<m ; i++){
            visited[sc.nextInt()] = true;
        }

        recur(0, 0);
        System.out.println(result);
    }
    private static void recur(int len, int count) {
        if(len == n) {
            if(count == m) {
                result++;
            }
            return;
        }

        for(int i=0 ; i<10 ; i++) {
            if(visited[i]) {
                visited[i] = false;
                recur(len + 1, count + 1);
                visited[i] = true;
            } else {
                recur(len + 1, count);
            }
        }
    }
}
