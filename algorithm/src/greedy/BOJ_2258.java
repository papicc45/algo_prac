package greedy;

import java.awt.desktop.PrintFilesEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Meet[] meets = new Meet[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            meets[i] = new Meet(weight, cost);
            sum += weight;
        }

        Arrays.sort(meets);
        for(int i=0 ; i<n ; i++) {
            System.out.println(meets[i].weight + " " + meets[i].cost);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (sum >= m) {
                if (result > meets[i].cost) {
                    result = meets[i].cost;
                }
            }
            sum -= meets[i].weight;
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }


    static class Meet implements Comparable<Meet> {
        int weight;
        int cost;

        public Meet(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Meet o) {
            if (this.weight == o.weight)
                return this.cost - o.cost;
            else
                return o.weight - this.weight;
        }
    }
}

