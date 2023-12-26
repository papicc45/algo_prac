package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price));
        }
        Collections.sort(jewels);

        ArrayList<Integer> bags = new ArrayList<>();
        for(int i=0 ; i<k ; i++) {
            int bag = Integer.parseInt(br.readLine());
            bags.add(bag);
        }
        Collections.sort(bags);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int index = 0;
        for(int i=0 ; i<k ; i++) {
            while(index < n && jewels.get(index).weight <= bags.get(i)) {
                queue.add(jewels.get(index++).price);
            }

            if(!queue.isEmpty()) {
                result += queue.poll();
            }
        }

        System.out.println(result);
    }
}

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        if(o.weight == this.weight) {
            return o.price - this.price;
        } else {
            return this.weight - o.weight;
        }
    }
}
