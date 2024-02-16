package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0 ; i<n ; i++) {
            String temp = br.readLine().split("\\.")[1];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String key : list) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
