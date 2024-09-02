package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> in = new HashSet<>();
        Set<String> out = new HashSet<>();
        Set<String> names = new HashSet<>();
        String str = null;

        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            String t = s[0];
            String n = s[1];

            names.add(n);
            if(S.compareTo(t) >= 0) {
                in.add(n);
            } else if(E.compareTo(t) <= 0 && Q.compareTo(t) >= 0) {
                out.add(n);
            }
        }

        int cnt = 0;
        for(String n : names) {
            if(in.contains(n) && out.contains(n))
                cnt++;
        }
        System.out.println(cnt);


    }
}
