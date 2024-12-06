package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Timer;

public class BOJ_26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int h1 = queue.poll();
            h1--;

            if(queue.size() != 0) {
                int h2 = queue.poll();
                h2--;
                if(h2 != 0)
                    queue.add(h2);
            }

            if(h1 != 0)
                queue.add(h1);
            time++;
        }

        if(time > 1440) {
            System.out.println("-1");
        } else {
            System.out.println(time);
        }

    }
}
