package datastructure.heapqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11286_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
           int num1 = Math.abs(o1);
           int num2 = Math.abs(o2);

           if(num1 == num2) {
               return o1 > o2 ? 1 : -1;
           } else {
               return num1 - num2;
           }
        });

        for(int i=0 ; i<n ; i++) {
            int num = sc.nextInt();
            if(num == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
    }
}
