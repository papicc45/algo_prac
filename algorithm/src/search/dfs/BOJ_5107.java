package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_5107 {
    static HashMap<String, String> hm;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            arr = new String[n];
            hm = new HashMap<>();
            for(int i=0 ; i<n ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                hm.put(s1, s2);
                arr[i] = s1;
            }

            int result = 0;
            for(int i=0 ; i<n ; i++) {
                String name = arr[i];
                if(hm.containsKey(name)) {
                    result++;
                    recur(name, name, 0);
                }
            }
            sb.append(num++).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void recur(String name, String start, int depth) {
        if(depth != 0 && name.equals(start))
            return;

        if(hm.containsKey(name)) {
            recur(hm.get(name), start, depth + 1);
            hm.remove(name);
        }
    }
}
