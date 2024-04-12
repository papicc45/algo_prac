package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15708 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long t = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int rock = Integer.parseInt(st.nextToken());
            sum += rock;
            queue.add(rock);
            while (sum > t - i * p) {
                if(queue.size() == 0)
                    break;

                sum -= queue.poll();
            }
            max = Math.max(max, queue.size());
        }
        System.out.println(max);
    }
}
