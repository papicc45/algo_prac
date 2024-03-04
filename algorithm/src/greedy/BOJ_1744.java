package greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1744 {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0 ; i<n ; i++) {
            int num = sc.nextInt();
            if(num == 1)
                result++;
            else if(num >= 2) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }
        cal(plus);
        cal(minus);
        System.out.println(result);
    }
    private static void cal(PriorityQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            if(queue.size() >= 2) {
                int n1 = queue.poll();
                int n2 = queue.poll();

                result += (n1 * n2);
            } else {
                result += queue.poll();
            }
        }
    }
}
