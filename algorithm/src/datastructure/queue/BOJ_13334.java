package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pairs[i] = new Pair(Math.min(a, b), Math.max(a, b));
        }

        int len = Integer.parseInt(br.readLine());
        Arrays.sort(pairs);
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            if(pairs[i].end - pairs[i].start <= len) {
                pq.add(pairs[i].start);

                while (!pq.isEmpty()) {
                    if(pairs[i].end - pq.peek() <= len)
                        break;

                    pq.poll();
                }
                result = Math.max(result, pq.size());
            }
        }
        System.out.println(result);
    }
    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }
}
