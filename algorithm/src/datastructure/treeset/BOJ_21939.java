package datastructure.treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ConnectionBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            set.add(new Problem(number, level));
            map.put(number, level);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                set.add(new Problem(number, level));
                map.put(number, level);
            } else if(command.equals("recommend")) {
                int type = Integer.parseInt(st.nextToken());

                if(type == 1) {
                    System.out.println(set.last().number);
                } else {
                    System.out.println(set.first().number);
                }
            } else {
                int number = Integer.parseInt(st.nextToken());
                set.remove(new Problem(number, map.get(number)));
                map.remove(number);
            }
        }
    }

    static class Problem implements Comparable<Problem>{
        int number;
        int level;

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }
        @Override
        public int compareTo(Problem o) {
            if(this.level == o.level) {
                return this.number - o.number;
            } else {
                return this.level - o.level;
            }
        }
    }
}
