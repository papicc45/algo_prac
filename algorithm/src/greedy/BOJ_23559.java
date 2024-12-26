package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_23559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        PriorityQueue<Food> queue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.add(new Food(a, b));
        }
        int result = 0;
        while (!queue.isEmpty()) {
            Food food = queue.poll();

            if(food.a > food.b && x - 5000 >= queue.size() * 1000) {
                x -= 5000;
                result += food.a;
            } else {
                x -= 1000;
                result += food.b;
            }
        }
        System.out.println(result);
    }
    static class Food implements Comparable<Food> {
        int a;
        int b;

        public Food(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Food o) {
            return Math.abs(o.a - o.b) - Math.abs(this.a - this.b);
        }
    }
}
