package greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_2036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int zero = 0;
        PriorityQueue<Long> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minus = new PriorityQueue<>();

        for(int i=0 ; i<n ; i++) {
            long num = sc.nextInt();
            if(num == 0) {
                zero++;
            } else if(num > 0) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }

        long sum = 0;
        while (!plus.isEmpty()) {
            long n1 = plus.poll();
            if(plus.size() >= 1) {
                long n2 = plus.poll();
                if(n2 == 1 || n1 == 1) {
                    sum += n1;
                    sum += n2;
                } else {
                    long add = (n1 * n2);
                    sum += add;
                }
            } else if(plus.size() == 0) {
                sum += n1;
            }
        }
        while (!minus.isEmpty()) {
            long n1 = minus.poll();
            if(minus.size() >= 1) {
                long n2 = minus.poll();
                long add = (n1 * n2);
                sum += add;
            } else if(plus.size() == 0) {
                if(zero == 0) {
                    sum += n1;
                } else {
                    zero--;
                }
            }
        }
        System.out.println(sum);
    }
}
