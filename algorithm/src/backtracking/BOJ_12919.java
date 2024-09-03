package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static int n;
    static String start;
    static String goal;
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = br.readLine();
        goal = br.readLine();
        n = goal.length();

        recur(goal);
        System.out.println(result ? 1 : 0);
    }
    private static void recur(String s) {
        if(result)
            return;

        if(s.equals(start)) {
            result = true;
            return;
        }

        if(s.length() == start.length())
            return;

        if(s.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(s).reverse();
            String next = sb.toString().substring(0, s.length() - 1);
            recur(next);
        }

        if(s.charAt(s.length() - 1) == 'A') {
            String next = s.substring(0, s.length() - 1);
            recur(next);
        }

    }
}

