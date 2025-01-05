package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            ArrayList<Party> parties = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) * 2;
                int end = Integer.parseInt(st.nextToken()) * 2;
                if(start == end)
                    continue;
                parties.add(new Party(start, end));
            }

            boolean[] check = new boolean[49];
            Collections.sort(parties);
            int result = 0;

            for(Party party : parties) {
                for(int i=party.start ; i<party.end ; i++) {
                    if(!check[i]) {
                        check[i] = true;
                        result++;
                        break;
                    }
                }
            }

            System.out.println("On day " + day++ +  " Emma can attend as many as " + result +  " parties." );
        }

    }
    static class Party implements Comparable<Party> {
        int start;
        int end;

        public Party(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Party o) {
            return this.end - o.end;
        }
    }
}
