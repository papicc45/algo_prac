package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static ArrayList<Character> list;
    static int l, c;
    static char[] result;
    static HashSet<Character> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        result = new char[l];
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<c ; i++) {
            list.add(st.nextToken().charAt(0));
        }

        Collections.sort(list);

        recur(0, 0, 0, 0);

    }
    private static void recur(int x, int idx, int cons, int vos) {
        if(idx == l) {
            if(cons >= 2 && vos >= 1) {
                System.out.println(result);
            }
            return;
        }

        for(int i=x ; i<c ; i++) {
            result[idx] = list.get(i);
            if(set.contains(list.get(i))) {
                recur(i+1, idx + 1, cons, vos + 1);
            } else {
                recur(i+1, idx+1, cons + 1, vos);
            }
        }
    }
}
