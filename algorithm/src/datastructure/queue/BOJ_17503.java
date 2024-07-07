package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicLong;

public class BOJ_17503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Beer[] beers = new Beer[k];
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i] = new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(beers);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        int result = 0;
        for(int i=0 ; i<k ; i++) {
            queue.add(beers[i].prefer);
            sum += beers[i].prefer;

            if(queue.size() > n) {
                sum -= queue.poll();
            }

            if(queue.size() == n && sum >= m) {
                result = beers[i].alcohol;
                break;
            }
        }
        if(result == 0)
            System.out.println("-1");
        else
            System.out.println(result);
    }
    static class Beer implements Comparable<Beer> {
        int prefer;
        int alcohol;

        public Beer(int prefer, int alcohol) {
            this.prefer = prefer;
            this.alcohol = alcohol;
        }

        @Override
        public int compareTo(Beer o) {
            return this.alcohol - o.alcohol;
        }
    }
}
