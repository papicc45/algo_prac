package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int k=0 ; k<t ; k++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Long> queue = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while(queue.size() != 1) {
                long chapter1 = queue.poll();
                long chapter2 = queue.poll();

                long sum = chapter1 + chapter2;
                queue.add(sum);
                result += sum;
            }

            System.out.println(result);
        }
    }
}
