package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_27979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        long cnt = 0;
        int ref = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur < ref) {
                cnt++;
                int value = cur;

                while(!queue.isEmpty() && queue.peek() < ref) {
                    cnt++;
                    value = queue.poll();
                }

                if(!queue.isEmpty()) {
                    ref = queue.peek();
                }

                while(!pq.isEmpty() && pq.peek() < value) {
                    pq.poll();
                    cnt++;
                }
            }
            else {
                ref = cur;
                pq.offer(cur);
            }
        }

        System.out.println(cnt);
    }
}
