package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20311 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] result = new int[n];

        Reagent[] reagents = new Reagent[k];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            reagents[i] = new Reagent(i+1, cnt);
            sum += cnt;
        }

        Arrays.sort(reagents);
        if(reagents[0].cnt > (n+1)/2) {
            System.out.println("-1");
            return;
        }

        int idx = 0;
        for(Reagent reagent : reagents) {

            while (reagent.cnt > 0) {
                if(idx >= n) {
                    idx = 1;
                }
                result[idx] = reagent.idx;
                idx += 2;
                reagent.cnt--;
            }
        }

        for(int i=0 ; i<n ; i++) {
            System.out.print(result[i] + " ");
        }
    }
    static class Reagent implements Comparable<Reagent> {
        int idx;
        int cnt;

        public Reagent(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Reagent o) {
            return o.cnt - this.cnt;
        }
    }
}
