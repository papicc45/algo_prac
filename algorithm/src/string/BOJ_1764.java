package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            set.add(str);
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            String str = br.readLine();
            if(set.contains(str)) {
                list.add(str);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String temp : list) {
            System.out.println(temp);
        }
    }
}
