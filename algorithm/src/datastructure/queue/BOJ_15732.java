package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15732 {
    static int n, k, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        PriorityQueue<Rule> queue = new PriorityQueue<>();
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int gap = Integer.parseInt(st.nextToken());
            queue.add(new Rule(start, end, gap));
        }

        int count = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Rule rule = queue.poll();
            int start = rule.start;
            int end = rule.end;
            int gap = rule.gap;

            count++;
            if(count == d) {
                result = start;
                break;
            }

            if(start + gap <= end) {
                Rule next = new Rule(start + gap, end, gap);
                queue.add(next);
            }
        }
        System.out.println(result);
    }
    static class Rule implements Comparable<Rule> {
        int start;
        int end;
        int gap;

        public Rule(int start, int end, int gap) {
            this.start = start;
            this.end = end;
            this.gap = gap;
        }

        @Override
        public int compareTo(Rule o) {
            if(this.start == o.start)
                return this.gap - o.gap;
            else
                return this.start - o.start;
        }
    }
}
