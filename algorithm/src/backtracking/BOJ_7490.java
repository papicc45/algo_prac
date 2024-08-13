package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_7490 {
    static int n;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=0 ; tc<t ; tc++) {
            n = sc.nextInt();
            sb = new StringBuilder();
            visited = new boolean[n+1];

            recur(0, new ArrayList<Integer>(), new ArrayList<String>());
            System.out.println(sb);
            System.out.println();
        }
    }
    private static void recur(int idx, ArrayList<Integer> num ,ArrayList<String> me) {
        if(idx == n-1) {
            //계산해야 됨
            return;
        }


    }
}
