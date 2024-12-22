package greedy;

import java.util.Scanner;

public class BOJ_12934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();

        long sum = x+y;

        long num = 1;
        long s = num;
        while (true) {
            if(s > sum) {
                System.out.println("-1");
                return;
            } else if(s == sum) {
                break;
            } else {
                num++;
                s += num;
            }
        }

        int result = 0;
        while (x > 0) {
            x -= num;
            num--;
            result++;
        }

        System.out.println(result);
    }
}
