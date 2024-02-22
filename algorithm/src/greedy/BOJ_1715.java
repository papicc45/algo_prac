package greedy;

import java.io.PipedReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            queue.add(sc.nextInt());
        }
        int result = 0;
        while (queue.size() != 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();

            queue.add(num1 + num2);
            result = result + num1 + num2;
        }
        System.out.println(result);
    }
}
