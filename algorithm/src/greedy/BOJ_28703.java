package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_28703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0 ; i<n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
            queue.add(num);
        }

        if(min == max) {
            System.out.println(0);
            return;
        }

        int diff = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if(diff > max - temp) {
                diff = max - temp;
            }

            temp *= 2;
            if(temp > max) {
                max = temp;
            } else {
                queue.add(temp);
            }
        }
        System.out.println(diff);
    }
}
