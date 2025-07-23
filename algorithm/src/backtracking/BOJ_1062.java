package backtracking;

import kotlin.random.AbstractPlatformRandom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {
    static int n, k, need;
    static boolean[] alpha = new boolean[26];
    static String[] words;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(k < 5) {
            System.out.println(0);
            return;
        } else if(k == 26) {
            System.out.println(n);
            return;
        }

        words = new String[n];
        for(int i=0 ; i<n ; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4);
        }
        char[] chars = new char[]{'a', 'n', 't', 'i', 'c'};
        for(int i=0 ; i<chars.length ; i++) {
            alpha[chars[i] - 'a'] = true;
        }

        need = k- 5;
        recur(0, 0);
        System.out.println(result);
    }
    private static void recur(int idx, int depth) {
        if(depth == need) {
            int cnt = 0;
            for(int i=0 ; i<words.length ; i++) {
                boolean check = true;
                for(int j=0 ; j<words[i].length() ; j++) {
                    if(!alpha[words[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                }
                if(check)
                    cnt++;
            }

            result = Math.max(result, cnt);
            return;
        }

        if(26 - idx < need - depth) return;

        for(int i=idx ; i<26 ; i++) {
            if(!alpha[i]) {
                alpha[i] = true;
                recur(i + 1, depth + 1);
                alpha[i] = false;
            }
        }
    }
}
