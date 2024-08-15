package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_7490 {
    static int n;
    static String[] operators = {"+", "-", " "};
    static ArrayList<String> answers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=0 ; tc<t ; tc++) {
            n = sc.nextInt();
            answers = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(answers);

            for(String str : answers)
                System.out.println(str);

            System.out.println();
        }
    }
    private static void dfs(int idx, String str) {
        if(idx == n) {
            String replace = str.replaceAll(" ", "");
            StringTokenizer st = new StringTokenizer(replace, "-|+", true);
            int sum = 0 ;
            while (st.hasMoreElements()) {
                String next = st.nextToken();
                if(next.equals("+"))
                    sum += Integer.parseInt(st.nextToken());
                else
                    sum -= Integer.parseInt(st.nextToken());
            }
            if(sum == 0)
                answers.add(str);

            return;
        }

        for(int i=0 ; i<3 ; i++) {
            dfs(idx + 1, str + operators[i] + (idx+1));
        }
    }

}
