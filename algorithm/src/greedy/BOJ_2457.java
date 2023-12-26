package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Flower> flowers = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers.add(new Flower(startMonth, startDay, endMonth, endDay));
        }
        Collections.sort(flowers);

        for(Flower flower : flowers) {
            System.out.println(flower.startMonth + " " + flower.startDay + " " + flower.endMonth + " " + flower.endDay);
        }

        if(!check(flowers.get(0).startMonth, flowers.get(0).startDay)) {
            System.out.println(0);
            return;;
        }
        PriorityQueue<Flower> queue = new PriorityQueue<>();
        queue.add(flowers.get(0));
        for(Flower flower : flowers) {

            if(queue.size() != 0) {
                Flower temp = queue.peek();
                if(flower.startMonth)
            }
        }
    }
    static boolean check(int startMonth, int startDay) {
        if(startMonth >= 3) {
            if(startDay >= 2) {
                return false;
            }
        }
        return true;
    }
}

class Flower implements Comparable<Flower>{
    int startMonth;
    int startDay;
    int endMonth;
    int endDay;

    public Flower(int startMonth, int startDay, int endMonth, int endDay) {
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }

    @Override
    public int compareTo(Flower o) {
        if(this.startMonth == o.startMonth) {
            return this.startDay - o.startDay;
        } else {
            return this.startMonth - o.startMonth;
        }
    }
}
