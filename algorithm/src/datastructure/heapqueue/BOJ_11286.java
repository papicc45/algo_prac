package datastructure.heapqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> plusQ = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> minusQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i=0 ; i<n ; i++) {
            int num = sc.nextInt();

            if(num == 0) {
                if(plusQ.isEmpty() && minusQ.isEmpty()) {
                    System.out.println(0);
                } else {
                    if(plusQ.isEmpty()) {
                        System.out.println(minusQ.poll());
                    }else if (minusQ.isEmpty()) {
                        System.out.println(plusQ.poll());
                    } else {
                        int plusValue = plusQ.peek();
                        int minusValue = Math.abs(minusQ.peek());
                        System.out.println(plusValue >= minusValue ? minusQ.poll() : plusQ.poll());
                    }
                }
            } else if(num < 0) {
                minusQ.add(num);
            } else {
                plusQ.add(num);
            }
        }

    }
}
